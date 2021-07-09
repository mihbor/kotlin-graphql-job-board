
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.Compression
import io.ktor.features.ContentNegotiation
import io.ktor.features.gzip
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resource
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.serialization.json
import model.Credentials

const val jwtSecret = "Zn8Q5tyZ/G1MHltc4F/gTkVJMlrbKiZt"

fun Route.login() {
  post("/login") {
    val credentials = call.receive<Credentials>()
    val user = data.users.find { it.email == credentials.email }
    if (user == null || user.password != credentials.password) {
      call.response.status(HttpStatusCode.Unauthorized)
    } else {
      val token = JWT.create()
        .withSubject(user.id)
        .sign(Algorithm.HMAC256(jwtSecret))
      call.respondText(token)
    }
  }
}

fun Application.restModule() {
  routing {
    login()
    static("/static") {
      resources()
    }
    static {
      resource("/js.js")
      resource("/{...}", "index.html")
    }
  }
  install(ContentNegotiation) {
    json()
  }
  install(CORS) {
    method(HttpMethod.Get)
    method(HttpMethod.Post)
    method(HttpMethod.Delete)
    anyHost()
  }
  install(Compression) {
    gzip()
  }
}