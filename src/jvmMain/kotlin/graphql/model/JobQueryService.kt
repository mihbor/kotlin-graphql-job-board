package graphql.model

import com.expediagroup.graphql.server.operations.Query
import jobs

class JobQueryService : Query {
  fun jobs() = jobs
  fun companies() = jobs
}