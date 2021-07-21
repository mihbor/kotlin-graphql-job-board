package graphql

import com.expediagroup.graphql.generator.execution.GraphQLContext
import io.ktor.auth.jwt.JWTPrincipal

data class AuthContext(
  val principal: JWTPrincipal?
) : GraphQLContext