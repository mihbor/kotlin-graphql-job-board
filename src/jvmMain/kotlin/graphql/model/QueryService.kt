package graphql.model

import com.expediagroup.graphql.server.operations.Query
import companies
import jobs

class QueryService : Query {
  fun jobs() = jobs
  fun job(id: String) = jobs.find { it.id == id }
  fun companies() = companies
  fun company(id: String) = companies.find { it.id == id }
}