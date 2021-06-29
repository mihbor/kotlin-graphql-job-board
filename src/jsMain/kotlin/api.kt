import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.window
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import model.Credentials
import model.Job

val origin = window.location.origin // only needed until https://youtrack.jetbrains.com/issue/KTOR-453 is resolved

val http = HttpClient {
  install(JsonFeature) {
    serializer = KotlinxSerializer()
    acceptContentTypes += ContentType.Text.Plain
  }
}

@Serializable
data class Data(
  val jobs: List<Job>? = null,
  val job: Job? = null
)

@Serializable
data class GraphQLResponse (
  val data: Data,
  val errors: Array<@Contextual Any>? = null
)

@Serializable
data class GraphQLRequest (val query: String?)

object API {
  suspend fun login(credentials: Credentials) = http.post<String?>("$origin/login") {
    contentType(ContentType.Application.Json)
    body = credentials
  }
  suspend inline fun query(query: String) = http.post<GraphQLResponse>("$origin/graphql") {
    contentType(ContentType.Application.Json)
    body = GraphQLRequest(query)
  }
}
