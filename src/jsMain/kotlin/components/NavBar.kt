package components

import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.a
import react.dom.div
import react.dom.nav
import react.functionalComponent
import react.router.dom.RouteResultHistory
import react.router.dom.routeLink
import react.router.dom.useHistory

external interface NavBarProps : RProps {
  var isLoggedIn: Boolean
  var onLogout: (RouteResultHistory) -> Unit
}

val navBar = functionalComponent<NavBarProps> { props ->
  val history = useHistory()
  nav(classes = "navbar") {
    div(classes = "navbar-start") {
      routeLink(to = "/", className = "navbar-item") {
        +"Home"
      }
      if (props.isLoggedIn) {
        routeLink(to = "/jobs/new", className = "navbar-item") {
          +"Post Job"
        }
        a(classes = "navbar-item") {
          attrs.onClickFunction = { event ->
            props.onLogout.invoke(history)
          }
          +"Log out"
        }
      } else {
        routeLink(to = "/login", className = "navbar-item") {
          +"Log in"
        }
      }
    }
  }
}