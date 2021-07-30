@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import kotlin.js.Json

external interface QueryBaseOptions<TVariables> {
    var query: Any
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var errorPolicy: String? /* "none" | "ignore" | "all" */
        get() = definedExternally
        set(value) = definedExternally
    var fetchResults: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var metadata: Any?
        get() = definedExternally
        set(value) = definedExternally
    var context: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryOptions<TVariables> : QueryBaseOptions<TVariables> {
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryOptions__0 : QueryOptions<OperationVariables>

external interface ModifiableWatchQueryOptions<TVariables> : QueryBaseOptions<TVariables> {
    var pollInterval: Number?
        get() = definedExternally
        set(value) = definedExternally
    var notifyOnNetworkStatusChange: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var returnPartialData: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WatchQueryOptions<TVariables> : QueryBaseOptions<TVariables>, ModifiableWatchQueryOptions<TVariables> {
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" | "cache-and-network" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface WatchQueryOptions__0 : WatchQueryOptions<OperationVariables>

external interface FetchMoreQueryOptions<TVariables, K : Any> {
    var query: Any?
        get() = definedExternally
        set(value) = definedExternally
    var variables: Any?
        get() = definedExternally
        set(value) = definedExternally
    var context: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$25`<TSubscriptionData> {
    var data: TSubscriptionData
}

external interface `T$26`<TSubscriptionVariables> {
    var subscriptionData: `T$25`<Any?>
    var variables: TSubscriptionVariables?
        get() = definedExternally
        set(value) = definedExternally
}

typealias UpdateQueryFn<TData, TSubscriptionVariables, TSubscriptionData> = (previousQueryResult: TData, options: `T$26`<TSubscriptionVariables>) -> TData

external interface SubscribeToMoreOptions<TData, TSubscriptionVariables, TSubscriptionData> {
    var document: Any
    var variables: TSubscriptionVariables?
        get() = definedExternally
        set(value) = definedExternally
    var updateQuery: UpdateQueryFn<TData, TSubscriptionVariables, TSubscriptionData>?
        get() = definedExternally
        set(value) = definedExternally
    var onError: ((error: Error) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubscribeToMoreOptions__0 : SubscribeToMoreOptions<Any, OperationVariables, Any>

external interface SubscriptionOptions<TVariables> {
    var query: Any
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubscriptionOptions__0 : SubscriptionOptions<OperationVariables>

typealias RefetchQueryDescription = Array<dynamic /* String | PureQueryOptions */>

external interface MutationBaseOptions<T, TVariables> {
    var optimisticResponse: dynamic /* T? | ((vars: TVariables) -> T)? */
        get() = definedExternally
        set(value) = definedExternally
    var updateQueries: MutationQueryReducersMap<T>?
        get() = definedExternally
        set(value) = definedExternally
    var refetchQueries: dynamic /* ((result: ExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */) -> RefetchQueryDescription)? | RefetchQueryDescription? */
        get() = definedExternally
        set(value) = definedExternally
    var awaitRefetchQueries: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var update: MutationUpdaterFn<T>?
        get() = definedExternally
        set(value) = definedExternally
    var errorPolicy: String? /* "none" | "ignore" | "all" */
        get() = definedExternally
        set(value) = definedExternally
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MutationOptions<T, TVariables> : MutationBaseOptions<T, TVariables> {
    var mutation: Any
    var context: Any?
        get() = definedExternally
        set(value) = definedExternally
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface MutationOptions__0 : MutationOptions<Json, OperationVariables>

typealias MutationUpdaterFn<T> = (proxy: DataProxy, mutationResult: LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */) -> Unit