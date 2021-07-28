package model

import kotlinx.serialization.Serializable
import kotlin.js.JsName

@Serializable
data class Company(
  val id: String,
  val name: String? = null,
  val description: String? = null
) {
  @JsName("nemo")
  var jobs: List<Job>? = null
  fun jobs() = jobs
}

@Serializable
data class Job(
  val id: String,
  val title: String? = null,
  val description: String? = null,
  val company: Company? = null
)

@Serializable
data class Token(
  val token: String
)

@Serializable
data class Credentials(
  val email: String,
  val password: String
)

@Serializable
data class User(
  val id: String,
  val email: String,
  val password: String,
  val companyId: String
)