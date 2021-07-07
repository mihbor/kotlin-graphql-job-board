package components

import API
import kotlinx.coroutines.launch
import model.Company
import propsToMap
import react.RProps
import react.dom.div
import react.dom.h1
import react.functionalComponent
import react.router.dom.useRouteMatch
import react.useEffect
import react.useState

val companyDetail = functionalComponent<RProps> {
  val match = useRouteMatch<RProps>()!!
  val companyId = propsToMap(match.params)["companyId"]
  val (company, setCompany) = useState(null as Company?)

  useEffect(emptyList()) {
    scope.launch {
      setCompany(
        API.query(
          "query Company(\$id: String!) { company(id: \$id) { name description } }",
          mapOf("id" to companyId)
        ).data?.company
      )
    }
  }

  div {
    h1("title") { +(company?.name ?: "Company not found") }
    div("box") { +(company?.description ?: "Company not found") }
  }
}