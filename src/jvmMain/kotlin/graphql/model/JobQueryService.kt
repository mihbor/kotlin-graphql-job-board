package graphql.model

import com.expediagroup.graphql.server.operations.Query
import jobs

class JobQueryService : Query {
  fun jobs() = jobs
  fun job(id: String) = jobs.find { it.id == id }
  fun companies() = jobs
}