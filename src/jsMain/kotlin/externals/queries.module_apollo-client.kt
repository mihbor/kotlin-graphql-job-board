@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import apollo.react.ExecutionResult

external interface QueryStoreValue {
    var document: Any
    var variables: Any
    var previousVariables: Any?
        get() = definedExternally
        set(value) = definedExternally
    var networkStatus: NetworkStatus
    var networkError: Error?
        get() = definedExternally
        set(value) = definedExternally
    var graphQLErrors: Array<GraphQLError>?
        get() = definedExternally
        set(value) = definedExternally
    var metadata: Any
}

external interface `T$16` {
    @nativeGetter
    operator fun get(queryId: String): QueryStoreValue?
    @nativeSetter
    operator fun set(queryId: String, value: QueryStoreValue)
}

external interface `T$17` {
    var queryId: String
    var document: Any
    var storePreviousVariables: Boolean
    var variables: Any
    var isPoll: Boolean
    var isRefetch: Boolean
    var metadata: Any
    var fetchMoreForQueryId: String?
}

external open class QueryStore {
    open var store: Any
    open fun getStore(): `T$16`
    open fun get(queryId: String): QueryStoreValue
    open fun initQuery(query: `T$17`)
    open fun <T> markQueryResult(queryId: String, result: ExecutionResult<T>, fetchMoreForQueryId: String?)
    open fun markQueryError(queryId: String, error: Error, fetchMoreForQueryId: String?)
    open fun markQueryResultClient(queryId: String, complete: Boolean)
    open fun stopQuery(queryId: String)
    open fun reset(observableQueryIds: Array<String>)
}