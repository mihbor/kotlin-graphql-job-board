package graphql

import com.expediagroup.graphql.server.operations.Mutation
import data
import model.Job
import java.util.UUID

class Mutations : Mutation {
  fun createJob(companyId: String, title: String, description: String, context: AuthContext): Job {
    println(context)
    if (context.principal == null) {
      throw Exception("Forbidden")
    }
    val id = UUID.randomUUID().toString()
    val job = Job(id, title, description, data.companiesById[companyId])
    data.jobs.add(job)
    return job
  }
}