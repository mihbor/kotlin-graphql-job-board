import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.window
import model.Credentials

val origin = window.location.origin // only needed until https://youtrack.jetbrains.com/issue/KTOR-453 is resolved

val http = HttpClient {
  install(JsonFeature) { serializer = KotlinxSerializer() }
}

object API {
  suspend fun login(credentials: Credentials) = http.post<String?>("$origin/login") {
    contentType(ContentType.Application.Json)
    body = credentials
  }
}
