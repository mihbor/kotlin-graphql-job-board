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
  val (jobs, setJobs) = useState(null as List<Job>?)
  useEffect(emptyList()) {
    scope.launch {
      setJobs(
        json.decodeFromDynamic<List<Job>>(
          Apollo.query(
            "query { jobs { id title description company { id name description } } }",
            fetchPolicy = "no-cache"
          ).data?.jobs
        )
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