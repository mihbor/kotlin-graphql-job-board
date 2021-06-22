package components

import model.Job
import react.RProps
import react.dom.div
import react.dom.key
import react.dom.li
import react.dom.ul
import react.functionalComponent
import react.router.dom.routeLink

external interface JobListProps: RProps {
  var jobs: Array<Job>?
}

val jobList = functionalComponent<JobListProps> { props ->
  ul("box") {
    props.jobs?.map { job ->
      val title = job.company?.let{"${job.title} at ${job.company.name}"} ?: job.title
      li("media") {
        attrs.key = job.id
        div("media-content") {
          routeLink("/jobs/${job.id}") { +title }
        }
      }
    }
  }
}