@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo.react

import global.JSX.Element
import graphql.DocumentNode

external interface QueryComponentOptions<TData, TVariables> : QueryFunctionOptions<TData, TVariables> {
    var children: (result: QueryResult<TData, TVariables>) -> Element?
    var query: DocumentNode
}

external interface MutationComponentOptions<TData, TVariables> : BaseMutationOptions<TData, TVariables> {
    var mutation: DocumentNode
    var children: (mutateFunction: MutationFunction<TData, TVariables>, result: MutationResult<TData>) -> Element?
}

external interface SubscriptionComponentOptions<TData, TVariables> : BaseSubscriptionOptions<TData, TVariables> {
    var subscription: DocumentNode
    var children: ((result: SubscriptionResult<TData>) -> Element?)?
        get() = definedExternally
        set(value) = definedExternally
}