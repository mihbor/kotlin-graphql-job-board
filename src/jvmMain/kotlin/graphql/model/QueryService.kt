package graphql.model

import com.expediagroup.graphql.server.operations.Query
import data
import model.Company

class QueryService : Query {
  fun jobs() = data.jobs
  fun job(id: String) = data.jobs.find { it.id == id }
  fun companies() = data.companies.withJobs()
  fun company(id: String) = data.companies.find { it.id == id }?.withJobs()
}

private fun Company.withJobs(): Company {
  this.jobs = data.jobs.filter { it.company == this }
  return this
}
private fun List<Company>.withJobs() = this.map(Company::withJobs)