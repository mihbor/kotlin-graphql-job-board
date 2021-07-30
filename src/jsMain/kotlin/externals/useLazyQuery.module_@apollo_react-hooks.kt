@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("@apollo/react-hooks")
@file:JsNonModule

package apollo.react

import graphql.DocumentNode

@JsName("useLazyQuery")
external fun <TData, TVariables> useLazyQueryJs(query: DocumentNode, options: LazyQueryHookOptions<TData, TVariables> = definedExternally): dynamic /* JsTuple<(options: QueryLazyOptions<TVariables>) -> Unit, QueryResult<TData, TVariables>> */