@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo.react

import apollo.ApolloError
import apollo.MutationUpdaterFn
import apollo.NetworkStatus
import tsstdlib.Record
import kotlin.js.Promise

//typealias OperationVariables = Record<String, Any>

typealias Context = Record<String, Any>

external interface ExecutionResult<T> {
    var data: T?
        get() = definedExternally
        set(value) = definedExternally
    var extensions: Record<String, Any>?
        get() = definedExternally
        set(value) = definedExternally
    var errors: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface BaseQueryOptions<TVariables> {
    var ssr: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" | "cache-and-network" */
        get() = definedExternally
        set(value) = definedExternally
    var errorPolicy: String? /* "none" | "ignore" | "all" */
        get() = definedExternally
        set(value) = definedExternally
    var pollInterval: Number?
        get() = definedExternally
        set(value) = definedExternally
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
    var notifyOnNetworkStatusChange: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var context: Context?
        get() = definedExternally
        set(value) = definedExternally
    var partialRefetch: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var returnPartialData: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryFunctionOptions<TData, TVariables> : BaseQueryOptions<TVariables> {
    var displayName: String?
        get() = definedExternally
        set(value) = definedExternally
    var skip: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var onCompleted: ((data: TData) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onError: ((error: ApolloError) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryResult<TData, TVariables> /*: ObservableQueryFields<TData, TVariables>*/ {
    var client: Any
    var data: TData?
    var previousData: TData?
    var error: ApolloError?
        get() = definedExternally
        set(value) = definedExternally
    var loading: Boolean
    var networkStatus: NetworkStatus
    var called: Boolean
}

typealias RefetchQueriesFunction = (args: Any) -> Array<dynamic /* String | PureQueryOptions */>

external interface BaseMutationOptions<TData, TVariables> {
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var optimisticResponse: dynamic /* TData? | ((vars: TVariables) -> TData)? */
        get() = definedExternally
        set(value) = definedExternally
    var refetchQueries: dynamic /* Array<dynamic /* String | PureQueryOptions */>? | RefetchQueriesFunction? */
        get() = definedExternally
        set(value) = definedExternally
    var awaitRefetchQueries: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var errorPolicy: String? /* "none" | "ignore" | "all" */
        get() = definedExternally
        set(value) = definedExternally
    var update: MutationUpdaterFn<TData>?
        get() = definedExternally
        set(value) = definedExternally
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
    var notifyOnNetworkStatusChange: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var context: Context?
        get() = definedExternally
        set(value) = definedExternally
    var onCompleted: ((data: TData) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onError: ((error: ApolloError) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" | "cache-and-network" */
        get() = definedExternally
        set(value) = definedExternally
    var ignoreResults: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MutationFunctionOptions<TData, TVariables> {
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var optimisticResponse: dynamic /* TData? | ((vars: dynamic /* TVariables | Any */) -> TData)? */
        get() = definedExternally
        set(value) = definedExternally
    var refetchQueries: dynamic /* Array<dynamic /* String | PureQueryOptions */>? | RefetchQueriesFunction? */
        get() = definedExternally
        set(value) = definedExternally
    var awaitRefetchQueries: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var update: MutationUpdaterFn<TData>?
        get() = definedExternally
        set(value) = definedExternally
    var context: Context?
        get() = definedExternally
        set(value) = definedExternally
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" | "cache-and-network" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface MutationResult<TData> {
    var data: TData?
        get() = definedExternally
        set(value) = definedExternally
    var error: ApolloError?
        get() = definedExternally
        set(value) = definedExternally
    var loading: Boolean
    var called: Boolean
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
}

typealias MutationFunction<TData, TVariables> = (options: MutationFunctionOptions<TData, TVariables>) -> Promise<ExecutionResult<TData> /* ExecutionResult<TData> & `T$11`<Record<string, any>, Record<string, any>> */>

external interface OnSubscriptionDataOptions<TData> {
    var client: Any
    var subscriptionData: SubscriptionResult<TData>
}

external interface BaseSubscriptionOptions<TData, TVariables> {
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var fetchPolicy: String? /* "cache-first" | "network-only" | "cache-only" | "no-cache" | "standby" */
        get() = definedExternally
        set(value) = definedExternally
    var shouldResubscribe: dynamic /* Boolean? | ((options: BaseSubscriptionOptions<TData, TVariables>) -> Boolean)? */
        get() = definedExternally
        set(value) = definedExternally
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
    var skip: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var onSubscriptionData: ((options: OnSubscriptionDataOptions<TData>) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var onSubscriptionComplete: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubscriptionResult<TData> {
    var loading: Boolean
    var data: TData?
        get() = definedExternally
        set(value) = definedExternally
    var error: ApolloError?
        get() = definedExternally
        set(value) = definedExternally
}