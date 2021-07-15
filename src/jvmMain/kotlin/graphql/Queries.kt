package graphql

import com.expediagroup.graphql.server.operations.Query
import data
import model.Company
import model.Job

class Queries : Query {
  fun jobs(): List<Job> = data.jobs
  fun job(id: String): Job? = data.jobs.find { it.id == id }
  fun companies(): List<Company> = data.companies.withJobs()
  fun company(id: String): Company? = data.companies.find { it.id == id }?.withJobs()
}

private fun Company.withJobs(): Company {
  this.jobs = data.jobs.filter { it.company == this }
  return this
}
private fun List<Company>.withJobs() = this.map(Company::withJobs)