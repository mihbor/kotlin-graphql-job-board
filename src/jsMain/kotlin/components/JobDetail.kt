package components

import API
import kotlinx.coroutines.launch
import model.Job
import propsToMap
import react.RProps
import react.dom.div
import react.dom.h1
import react.dom.h2
import react.functionalComponent
import react.router.dom.routeLink
import react.router.dom.useRouteMatch
import react.useEffect
import react.useState

val jobDetail = functionalComponent<RProps> {
  val match = useRouteMatch<RProps>()!!
  val jobId = propsToMap(match.params)["jobId"]
  val (job, setJob) = useState(null as Job?)

  useEffect(emptyList()) {
    scope.launch {
      setJob(
        API.graphql(
          "query Job(\$id: String!) { job(id: \$id) { id title description company { id name } } }",
          mapOf("id" to jobId)
        ).data?.job
      )
    }
  }

  job?.let{
    div {
      job.title?.let { h1("title") { +it } }
      h2("subtitle") {
        job.company?.let{ routeLink("/companies/${it.id}") { +(it.name ?: "No Name") } }
      }
      job.description?.let{ div("box") { +it } }
    }
  }
}