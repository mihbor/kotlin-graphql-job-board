import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.browser.window
import kotlinx.serialization.Serializable
import model.Credentials
import model.Job

val origin = window.location.origin // only needed until https://youtrack.jetbrains.com/issue/KTOR-453 is resolved

val http = HttpClient {
  install(JsonFeature) {
    serializer = KotlinxSerializer(json)
    acceptContentTypes += ContentType.Text.Plain

  }
}

@Serializable
data class Data(
  val jobs: List<Job>? = null,
  val job: Job? = null
)

@Serializable
data class GraphQLResponse(
  val data: Data? = null,
  val errors: Array<GraphQLError>? = null
)

@Serializable
data class GraphQLError(
  val message: String
)

@Serializable
data class GraphQLRequest (val query: String?, val variables: Map<String, String?>? = null)

object API {
  suspend fun login(credentials: Credentials) = http.post<String?>("$origin/login") {
    contentType(ContentType.Application.Json)
    body = credentials
  }
  suspend inline fun query(query: String, variables: Map<String, String?>? = null) = http.post<GraphQLResponse>("$origin/graphql") {
    contentType(ContentType.Application.Json)
    body = GraphQLRequest(query, variables)
  }
}
