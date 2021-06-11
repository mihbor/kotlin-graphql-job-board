
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import model.Credentials
import users

const val jwtSecret = "Zn8Q5tyZ/G1MHltc4F/gTkVJMlrbKiZt"

fun Route.login() {
  post("/login") {
    val credentials = call.receive<Credentials>()
    val user = users.find { it.email == credentials.email }
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