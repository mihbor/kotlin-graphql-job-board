import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.child

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
