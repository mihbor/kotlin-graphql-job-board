import react.RProps
import react.dom.div
import react.dom.h1
import react.dom.h2
import react.functionalComponent
import react.router.dom.routeLink
import react.router.dom.useRouteMatch
import react.useState

val jobDetail = functionalComponent<RProps> {
  val match = useRouteMatch<RProps>()!!
  val (job, setJob) = useState(jobs.find{ it.id == propsToMap(match.params)["jobId"]} )

  div {
    h1("title") { +(job?.title ?: "Not Found") }
    h2("subtitle") {
      job?.company?.let{ routeLink("/companies/${it.id}") { +it.name } }
    }
    div("box") { +(job?.description ?: "Not Found") }
  }
}