import model.Company
import model.Job

val companies = listOf(
  Company(
    id = "company1",
    name = "Company A",
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
  ),
  Company(
    id = "company2",
    name = "Company B",
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
  )
)

val jobs = listOf(
  Job(
    id = "job1",
    title = "Job 1",
    company = companies[0],
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
  ),
  Job(
    id = "job2",
    title = "Job 2",
    company = companies[1],
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
  )
)
