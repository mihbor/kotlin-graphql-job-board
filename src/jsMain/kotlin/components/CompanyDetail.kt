package components

import Apollo
import json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.decodeFromDynamic
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
  var company by useState(null as Company?)

  useEffect(emptyList()) {
    scope.launch {
      company =  json.decodeFromDynamic<Company>(
        Apollo.query(
          "query Company(\$id: String!) { company(id: \$id) { id name description jobs { id title } } }",
          fetchPolicy = "no-cache"
        ) {
          id = companyId
        }.data?.company
      )
    }
  }

  div {
    company?.let {
      h1("title") { +(it.name ?: "") }
      div("box") { +(it.description ?: "") }
      h5("title is-5") { +"Jobs at ${it.name}" }
      child(jobList) {
        attrs.jobs = it.jobs
      }
    } ?: h1("title") { +"Company not found" }
  }
}