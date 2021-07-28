package graphql

import com.expediagroup.graphql.server.operations.Mutation
import data
import model.Job
import java.util.UUID

class Mutations : Mutation {
  fun createJob(title: String, description: String, context: AuthContext): Job {
    println(context.principal)
    if (context.principal == null) {
      throw Exception("Forbidden")
    } else {
      val id = UUID.randomUUID().toString()
      val job = Job(id, title, description, data.companiesById[data.usersById[context.principal.subject!!]!!.companyId])
      data.jobs.add(job)
      return job
    }
  }
}