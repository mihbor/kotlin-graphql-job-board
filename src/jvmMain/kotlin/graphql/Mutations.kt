package graphql

import com.expediagroup.graphql.server.operations.Mutation
import data
import model.Job
import java.util.*

class Mutations : Mutation {
  fun createJob(companyId: String, title: String, description: String): String {
    val id = UUID.randomUUID().toString()
    data.jobs.add(Job(id, title, description, data.companiesById[companyId]))
    return id
  }
}