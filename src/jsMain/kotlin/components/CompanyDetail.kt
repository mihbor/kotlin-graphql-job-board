package components

import API
import kotlinx.coroutines.launch
import model.Company
import propsToMap
import react.*
import react.dom.div
import react.dom.h1
import react.dom.h5
import react.router.dom.useRouteMatch

val companyDetail = functionalComponent<RProps> {
  val match = useRouteMatch<RProps>()!!
  val companyId = propsToMap(match.params)["companyId"]
  val (company, setCompany) = useState(null as Company?)

  useEffect(emptyList()) {
    scope.launch {
      setCompany(
        API.query(
          "query Company(\$id: String!) { company(id: \$id) { id name description jobs { id title } } }",
          mapOf("id" to companyId)
        ).data?.company
      )
    }
  }

  div {
    company?.let {
      h1("title") { +(company.name ?: "") }
      div("box") { +(company.description ?: "") }
      h5("title is-5") { +"Jobs at ${company.name}" }
      child(jobList) {
        attrs.jobs = company.jobs
      }
    } ?: h1("title") { +"Company not found" }
  }
}