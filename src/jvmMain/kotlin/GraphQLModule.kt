/*
 * Copyright 2021 Expedia, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import graphql.getGraphQLServer
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.graphQLModule() {
    install(Routing)

    routing {
        post("graphql") {
            handle(call)
        }

        get("playground") {
            call.respondText(buildPlaygroundHtml("graphql", "subscriptions"), ContentType.Text.Html)
        }
    }
}

val mapper = jacksonObjectMapper()
val ktorGraphQLServer = getGraphQLServer(mapper)

/**
 * Handle incoming Ktor Http requests and send them back to the response methods.
 */
suspend fun handle(applicationCall: ApplicationCall) {
    // Execute the query against the schema
    val result = ktorGraphQLServer.execute(applicationCall.request)

    if (result != null) {
        // write response as json
        val json = mapper.writeValueAsString(result)
        applicationCall.response.call.respond(json)
    } else {
        applicationCall.response.call.respond(HttpStatusCode.BadRequest, "Invalid request")
    }
}
private fun buildPlaygroundHtml(graphQLEndpoint: String, subscriptionsEndpoint: String) =
    Application::class.java.classLoader.getResource("graphql-playground.html")?.readText()
        ?.replace("\${graphQLEndpoint}", graphQLEndpoint)
        ?.replace("\${subscriptionsEndpoint}", subscriptionsEndpoint)
        ?: throw IllegalStateException("graphql-playground.html cannot be found in the classpath")
