package graphql.model

import com.expediagroup.graphql.server.operations.Query
import model.Job

class JobQueryService : Query {
  fun jobs() = listOf<Job>()
}