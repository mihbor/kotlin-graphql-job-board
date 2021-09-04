package components

import Apollo
import graphql.gql
import json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.decodeFromDynamic
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

val jobFragment = """fragment JobFragment on Job {
  id title description company {
      id name description
    }
}"""

val jobQuery = gql("query Job(\$id: String!) { job(id: \$id) { ...JobFragment } } $jobFragment")

val jobDetail = functionalComponent<RProps> {
  val match = useRouteMatch<RProps>()!!
  val jobId = propsToMap(match.params)["jobId"]
  var job by useState(null as Job?)

  useEffect(emptyList()) {
    scope.launch {
      job = json.decodeFromDynamic<Job>(
        Apollo.query(jobQuery) {
          id = jobId
        }.data?.job
      )
    }
  }

  job?.let{
    div {
      it.title?.let { h1("title") { +it } }
      h2("subtitle") {
        it.company?.let{ routeLink("/companies/${it.id}") { +(it.name ?: "No Name") } }
      }
      it.description?.let{ div("box") { +it } }
    }
  }
}