import react.RProps
import react.child
import react.dom.div
import react.dom.h1
import react.functionalComponent

val jobBoard = functionalComponent<RProps> {
  div {
    h1("title") { +"Job Board" }
    child(jobList) {
      attrs.jobs = jobs
    }
  }
}