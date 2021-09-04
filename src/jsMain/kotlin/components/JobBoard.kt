package components

import Apollo
import json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.decodeFromDynamic
import model.Job
import react.*
import react.dom.div
import react.dom.h1

val jobBoard = functionalComponent<RProps> {
  var jobs by useState(null as List<Job>?)
  useEffect(emptyList()) {
    scope.launch {
      jobs = json.decodeFromDynamic<List<Job>>(
        Apollo.query(
          "query { jobs { ...JobFragment } } $jobFragment",
          fetchPolicy = "no-cache"
        ).data?.jobs
      )
    }
  }
  div {
    h1("title") { +"Job Board" }
    child(jobList) {
      attrs.jobs = jobs
    }
  }
}