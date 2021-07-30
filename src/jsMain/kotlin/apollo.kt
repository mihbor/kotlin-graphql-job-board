import apollo.*
import auth.accessToken
import auth.isLoggedIn
import graphql.DocumentNode
import graphql.gql
import kotlinx.coroutines.await

val authLink = ApolloLink { operation, forward ->
  if (isLoggedIn()) {
    val headers = js("{}")
    headers.authorization = "Bearer $accessToken"
    val context = js("{}")
    context.headers = headers
    operation.setContext(context)
  }
  forward(operation)
}

val httpLink = ApolloLink.from(arrayOf(
  authLink,
  HttpLink((js("{}") as HttpLink.Options).apply {
    uri = "http://localhost:8080/graphql"
  })
))

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

fun <T, TVariables> MutationOptions(
  mutation: DocumentNode,
  variablesProvider: (dynamic.() -> Unit)?
) = (js("{}") as MutationOptions<T, TVariables>).apply {
  this.mutation = mutation
  variablesProvider?.let {
    val variables = js("{}")
    it.invoke(variables)
    this.variables = variables
  }
}

object Apollo {
  suspend fun query(query: String, variables: (dynamic.() -> Unit)? = null) =
    apolloClient.query<dynamic, Any?>(QueryOptions(gql(query), variables)).await()

  suspend fun mutate(mutation: String, variables: (dynamic.() -> Unit)? = null) =
    apolloClient.mutate<dynamic, Any?>(MutationOptions(gql(mutation), variables)).await()
}