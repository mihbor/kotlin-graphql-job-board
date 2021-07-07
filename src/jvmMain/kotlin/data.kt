import model.Company
import model.Job
import model.User

val users = listOf(
  User(
    id = "BJrp-DudG",
    email = "alice@facegle.io",
    password = "alice123",
    companyId = "HJRa-DOuG"
  ),
  User(
    id = "ry9pbwdOz",
    email = "bob@goobook.co",
    password = "bob123",
    companyId = "SJV0-wdOM"
  )
)

val companies = listOf(
  Company(
    id = "HJRa-DOuG",
    name = "Facegle",
    description = "We are a startup on a mission to disrupt social search engines. Think Facebook meet Google."
  ),
  Company(
    id = "SJV0-wdOM",
    name = "Goobook",
    description = "We are a startup on a mission to disrupt search social media. Think Google meet Facebook."
  )
)

val companiesById = companies.map{ it.id to it }.toMap()

val jobs = listOf(
  Job(
    id = "rJKAbDd_z",
    company = companiesById["HJRa-DOuG"],
    title = "Frontend Developer",
    description = "We are looking for a Frontend Developer familiar with React."
  ),
  Job(
    id = "SJRAZDu_z",
    company = companiesById["HJRa-DOuG"],
    title = "Backend Developer",
    description = "We are looking for a Backend Developer familiar with Node.js and Express."
  ),
  Job(
    id = "rkz1GwOOM",
    company = companiesById["SJV0-wdOM"],
    title = "Full-Stack Developer",
    description = "We are looking for a Full-Stack Developer familiar with Node.js, Express, and React."
  )
)