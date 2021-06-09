import auth.logIn
import kotlinx.coroutines.launch
import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RProps
import react.dom.*
import react.functionalComponent
import react.router.dom.RouteResultHistory
import react.router.dom.useHistory
import react.useState

external interface LoginFormProps: RProps {
  var onLogin: (RouteResultHistory) -> Unit
}

val loginForm = functionalComponent<LoginFormProps> { props ->
  val (email, setEmail) = useState("")
  val (password, setPassword) = useState("")
  val (error, setError) = useState(false)
  val history = useHistory()

  val onSubmit: (Event) -> Unit = { event ->
    event.preventDefault()
    scope.launch {
      logIn(email, password)?.let {
        props.onLogin(history)
      } ?: setError(true)
    }
  }

  form {
    attrs.onSubmitFunction = onSubmit
    div("field") {
      label("label") { +"Email" }
      div("control") {
        input(InputType.text, classes = "input") {
          attrs {
            name = "email"
            value = email
            onChangeFunction = { setEmail((it.target as HTMLInputElement).value) }
          }
        }
      }
    }
    div("field") {
      label("label") { +"Password" }
      input(InputType.password, classes = "input") {
        attrs {
          name = "password"
          value = password
          onChangeFunction = { setPassword((it.target as HTMLInputElement).value) }
        }
      }
    }
    div("field") {
      p("help is-danger") { if(error) +"Invalid credentials" }
      div("control") {
        button(classes = "button is-link", type = ButtonType.submit) {
          +"Login"
        }
      }
    }
  }
}