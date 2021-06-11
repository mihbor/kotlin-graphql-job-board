package model

import kotlinx.serialization.Serializable

@Serializable
data class Company(
  val id: String,
  val name: String,
  val description: String
)

@Serializable
data class Job(
  val id: String,
  val title: String,
  val description: String,
  val company: Company?
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