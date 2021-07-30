@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import apollo.react.ExecutionResult
import graphql.DocumentNode
import kotlin.js.Promise

external interface QueryWithUpdater {
    var updater: MutationQueryReducer<Any>
    var query: QueryStoreValue
}

external interface `T$12` {
    @nativeGetter
    operator fun get(queryId: String): QueryWithUpdater?
    @nativeSetter
    operator fun set(queryId: String, value: QueryWithUpdater)
}

external interface `T$13` {
    var mutationId: String
    var document: Any
    var variables: Any
    var updateQueries: `T$12`
    var update: ((proxy: DataProxy, mutationResult: Any) -> Unit)?
    var optimisticResponse: dynamic /* Object? | Function<*>? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$14` {
    var mutationId: String
    var result: Any
    var document: Any
    var variables: Any
    var updateQueries: `T$12`
    var update: ((proxy: DataProxy, mutationResult: Any) -> Unit)?
}

external interface `T$15` {
    var mutationId: String
    var optimisticResponse: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external open class DataStore<TSerialized>(initialCache: ApolloCache<TSerialized>) {
    open var cache: Any
    open fun getCache(): ApolloCache<TSerialized>
    open fun <T> markQueryResult(result: ExecutionResult<T>, document: DocumentNode, variables: Any, fetchMoreForQueryId: String?, ignoreErrors: Boolean = definedExternally)
    open fun <T> markSubscriptionResult(result: ExecutionResult<T>, document: DocumentNode, variables: Any)
    open fun markMutationInit(mutation: `T$13`)
    open fun markMutationResult(mutation: `T$14`)
    open fun markMutationComplete(__0: `T$15`)
    open fun markUpdateQueryResult(document: DocumentNode, variables: Any, newResult: Any)
    open fun reset(): Promise<Unit>
}