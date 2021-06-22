package components

import API
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import model.Job
import react.*
import react.dom.div
import react.dom.h1

@Serializable
data class JobsResponse(val jobs: Array<Job>)

val jobBoard = functionalComponent<RProps> {
  val (jobs, setJobs) = useState(null as Array<Job>?)
  useEffect(emptyList()) {
    scope.launch {
      setJobs(
        API.query(
          "query { jobs { id title description company { id name description } } }"
        ).data.jobs
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