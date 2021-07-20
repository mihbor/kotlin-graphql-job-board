import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.browser.window
import kotlinx.serialization.Serializable
import model.Company
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
  val job: Job? = null,
  val companies: List<Company>? = null,
  val company: Company? = null
)

@Serializable
data class GraphQLResponse(
  val data: Data? = null,
  val errors: Array<GraphQLError>? = null
)

@Serializable
data class GraphQLError(
  val message: String,
  val locations: Array<Location>
)

@Serializable
data class Location(
  val line: Int,
  val column: Int
)

@Serializable
data class GraphQLRequest (val query: String?, val variables: Map<String, String?>? = null)

object API {
  suspend fun login(credentials: Credentials) = http.post<String?>("$origin/login") {
    contentType(ContentType.Application.Json)
    body = credentials
  }
  suspend inline fun graphql(query: String, variables: Map<String, String?>? = null): GraphQLResponse {
    val response = http.post<GraphQLResponse>("$origin/graphql") {
      contentType(ContentType.Application.Json)
      body = GraphQLRequest(query, variables)
    }
    if (response.errors.isNullOrEmpty()) {
      return response
    } else {
      val message = response.errors.map(GraphQLError::message).joinToString("\n")
      window.alert(message)
      throw Error(message)
    }
  }
}
