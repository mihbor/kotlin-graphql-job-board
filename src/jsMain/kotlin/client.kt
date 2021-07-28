import components.app
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import react.RProps
import react.child
import react.dom.render

fun propsToMap(props: RProps) = json.decodeFromString<Map<String, String>>(JSON.stringify(props))

fun main() {
  window.onload = {
    document.getElementById("root")
      ?.also { it.innerHTML = "" }
      ?.also {
        render(it) {
          child(app)
        }
      }
  }
}
