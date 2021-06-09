import react.RProps
import react.dom.div
import react.dom.h1
import react.functionalComponent
import react.router.dom.useRouteMatch
import react.useState

val companyDetail = functionalComponent<RProps> {
  val match = useRouteMatch<RProps>()!!
  val companyId = propsToMap(match.params)["companyId"]
  val (company, setCompany) = useState(companies.find{ it.id == companyId })

  div {
    h1("title") { +(company?.name ?: "Company not found") }
    div("box") { +(company?.description ?: "Company not found") }
  }
}