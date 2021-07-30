import apollo.*
import graphql.DocumentNode
import graphql.gql
import kotlinx.coroutines.await

val httpLink = createHttpLink(
  (js("{}") as HttpLink.Options).apply { uri = "http://localhost:8080/graphql" }
)

val apolloCache = InMemoryCache()

val apolloClient = ApolloClient(
  (js("{}") as ApolloClientOptions<NormalizedCacheObject>).apply {
    link = httpLink
    cache = apolloCache
  }
)

fun <TVariables> QueryOptions(
  query: DocumentNode,
  variablesProvider: (dynamic.() -> Unit)?
) = (js("{}") as QueryOptions<TVariables>).apply {
  this.query = query
  variablesProvider?.let {
    val variables = js("{}")
    it.invoke(variables)
    this.variables = variables
  }
}

object Apollo {
  suspend fun query(query: String, variables: (dynamic.() -> Unit)? = null) =
    apolloClient.query<dynamic, Any?>(QueryOptions(gql(query), variables)).await()
}