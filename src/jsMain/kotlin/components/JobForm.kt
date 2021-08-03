package components

import Apollo
import WriteQueryOptions
import json
import kotlinx.coroutines.launch
import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.serialization.json.decodeFromDynamic
import model.Job
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import react.RProps
import react.dom.button
import react.dom.div
import react.dom.form
import react.dom.h1
import react.dom.input
import react.dom.label
import react.dom.value
import react.functionalComponent
import react.router.dom.useHistory
import react.useState
import styled.css
import styled.styledTextarea as textarea

val jobForm = functionalComponent<RProps> {
  val (title, setTitle) = useState("")
  val (description, setDescription) = useState("")
  val history = useHistory()

  val submit: (Event) -> Unit = { event ->
    event.preventDefault()
    console.log("title: $title, description: $description")
    scope.launch {
      val job = json.decodeFromDynamic<Job>(
        Apollo.mutate(
          """mutation createJob{
            job: createJob(title: "$title" description: "$description") {
              id title description company {
                id name description
              }
            }
          }""",
          update = { cache, result ->
//            console.log("Writing ${result.data} for query ${components.jobQuery} with param ${result.data.job.id}")
            cache.writeQuery(WriteQueryOptions(jobQuery, result.data) {
              id = result.data.job.id
            })
          }
        ).data?.job
      )
      job.let{
        history.push("/jobs/${it.id}")
      }
    }
  }

  div {
    h1("title") {
      div("box") {
        form {
          div("field") {
            label("label") { +"Title" }
            div("control") {
              input(type = InputType.text, classes = "input", name = "title") {
                attrs {
                  value = title
                  onChangeFunction = { setTitle((it.target as HTMLInputElement).value) }
                }
              }
            }
          }
          div("field") {
            label("label") { +"Description" }
            div("control") {
              textarea {
                css {
                  classes = mutableListOf("input")
                  height = LinearDimension("10em")
                }
                attrs {
                  name = "description"
                  value = description
                  onChangeFunction = { setDescription((it.target as HTMLTextAreaElement).value) }
                }
              }
            }
          }
          div("field") {
            div("control") {
              button(classes = "button is-link") {
                attrs.onClickFunction = submit
                +"Submit"
              }
            }
          }
        }
      }
    }
  }
}