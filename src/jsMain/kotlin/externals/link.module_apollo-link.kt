@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("apollo-link")
@file:JsNonModule

package apollo

import ZenObservable.Observable

external open class ApolloLink(request: RequestHandler = definedExternally) {
    open fun split(test: (op: Operation) -> Boolean, left: ApolloLink, right: ApolloLink = definedExternally): ApolloLink
    open fun split(test: (op: Operation) -> Boolean, left: ApolloLink): ApolloLink
    open fun split(test: (op: Operation) -> Boolean, left: ApolloLink, right: RequestHandler = definedExternally): ApolloLink
    open fun split(test: (op: Operation) -> Boolean, left: RequestHandler, right: ApolloLink = definedExternally): ApolloLink
    open fun split(test: (op: Operation) -> Boolean, left: RequestHandler): ApolloLink
    open fun split(test: (op: Operation) -> Boolean, left: RequestHandler, right: RequestHandler = definedExternally): ApolloLink
    open fun concat(next: ApolloLink): ApolloLink
    open fun concat(next: RequestHandler): ApolloLink
    open fun request(operation: Operation, forward: NextLink = definedExternally): Observable<LocalExecutionResult<dynamic> /* ExecutionResult<dynamic> & `T$0`<Record<string, any>, Record<string, any>> */>?

    companion object {
        var empty: Any
        fun from(links: Array<ApolloLink>): ApolloLink
        var split: Any
        var execute: Any
    }
}