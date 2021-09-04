package components

import kotlinx.coroutines.MainScope
import react.RProps
import react.child
import react.dom.div
import react.dom.section
import react.functionalComponent
import react.router.dom.RouteResultHistory
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import react.useState

val scope = MainScope()

val app = functionalComponent<RProps>{

  var isLoggedIn by useState(auth.isLoggedIn())
  val logIn: (RouteResultHistory) -> Unit = { history ->
    isLoggedIn = true
    history.push("/")
  }
  val logOut: (RouteResultHistory) -> Unit = { history ->
    auth.logOut()
    isLoggedIn = false
    history.push("/")
  }

  browserRouter {
    div {
      child(navBar) {
        attrs.isLoggedIn = isLoggedIn
        attrs.onLogout = logOut
      }
      section("section") {
        div("container") {
          switch {
            route("/", exact = true) {
              child(jobBoard)
            }
            route("/companies/:companyId") {
              child(companyDetail)
            }
            route("/jobs/new", exact = true) {
              child(jobForm)
            }
            route("/jobs/:jobId") {
              child(jobDetail)
            }
            route("/login", exact = true) {
              child(loginForm) {
                attrs.onLogin = logIn
              }
            }
          }
        }
      }
    }
  }
}
