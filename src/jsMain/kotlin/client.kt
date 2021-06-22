import components.app
import kotlinx.browser.document
import kotlinx.browser.window
import react.child
import react.dom.render

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
