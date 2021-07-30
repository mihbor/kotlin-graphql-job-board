@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package apollo.react

import ZenObservable.Subscription
import apollo.ApolloClient
import apollo.ApolloError
import apollo.ObservableQuery
import global.JSX.Element
import graphql.DocumentNode
import tsstdlib.Omit

external interface QueryOptions<TData, TVariables> : QueryFunctionOptions<TData, TVariables> {
    var children: ((result: QueryResult<TData, TVariables>) -> dynamic)?
        get() = definedExternally
        set(value) = definedExternally
    var query: DocumentNode
}

external interface QueryHookOptions<TData, TVariables> : QueryFunctionOptions<TData, TVariables> {
    var query: DocumentNode?
        get() = definedExternally
        set(value) = definedExternally
}

external interface LazyQueryHookOptions<TData, TVariables> : Omit<QueryFunctionOptions<TData, TVariables>, String /* "skip" */> {
    var query: DocumentNode?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryPreviousData<TData, TVariables> {
    var client: ApolloClient<Any?>?
        get() = definedExternally
        set(value) = definedExternally
    var query: DocumentNode?
        get() = definedExternally
        set(value) = definedExternally
    var observableQueryOptions: Any?
        get() = definedExternally
        set(value) = definedExternally
    var result: QueryResult<TData, TVariables>?
        get() = definedExternally
        set(value) = definedExternally
    var loading: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var options: QueryOptions<TData, TVariables>?
        get() = definedExternally
        set(value) = definedExternally
    var error: ApolloError?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryCurrentObservable<TData, TVariables> {
    var query: ObservableQuery<TData, TVariables>?
        get() = definedExternally
        set(value) = definedExternally
    var subscription: Subscription?
        get() = definedExternally
        set(value) = definedExternally
}

external interface QueryLazyOptions<TVariables> {
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
    var context: Context?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MutationHookOptions<TData, TVariables> : BaseMutationOptions<TData, TVariables> {
    var mutation: DocumentNode?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MutationOptions<TData, TVariables> : BaseMutationOptions<TData, TVariables> {
    var mutation: DocumentNode
}

external interface SubscriptionHookOptions<TData, TVariables> : BaseSubscriptionOptions<TData, TVariables> {
    var subscription: DocumentNode?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubscriptionOptions<TData, TVariables> : BaseSubscriptionOptions<TData, TVariables> {
    var subscription: DocumentNode
    var children: ((result: SubscriptionResult<TData>) -> Element?)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubscriptionCurrentObservable {
    var query: Any?
        get() = definedExternally
        set(value) = definedExternally
    var subscription: Subscription?
        get() = definedExternally
        set(value) = definedExternally
}