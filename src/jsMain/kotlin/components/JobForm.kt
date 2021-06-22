package components

import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import react.RProps
import react.dom.*
import react.functionalComponent
import react.useState
import styled.css
import styled.styledTextArea as textArea

val jobForm = functionalComponent<RProps> {
  val (title, setTitle) = useState("")
  val (description, setDescription) = useState("")

  val submit: (Event) -> Unit = { event ->
    event.preventDefault()
    console.log("title: $title, description: $description")
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
              textArea {
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