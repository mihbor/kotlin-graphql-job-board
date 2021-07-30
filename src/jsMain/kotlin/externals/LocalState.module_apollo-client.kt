@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import graphql.DocumentNode
import tsstdlib.Record
import kotlin.js.Json
import kotlin.js.Promise

external interface `T$23` {
    var field: Any
}

typealias Resolver = (rootValue: Any, args: Any, context: Any, info: `T$23`) -> Any

typealias FragmentMatcher = (rootValue: Any, typeCondition: String, context: Any) -> Boolean

external interface LocalStateOptions<TCacheShape> {
    var cache: ApolloCache<TCacheShape>
    var client: Any?
        get() = definedExternally
        set(value) = definedExternally
    var resolvers: dynamic /* Resolvers? | Array<Resolvers>? */
        get() = definedExternally
        set(value) = definedExternally
    var fragmentMatcher: FragmentMatcher?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$20`<TData> {
    var document: Any?
    var remoteResult: LocalExecutionResult<TData> /* ExecutionResult<TData> & `T$11`<Record<string, any>, Record<string, any>> */
    var context: Record<String, Any>?
        get() = definedExternally
        set(value) = definedExternally
    var variables: Record<String, Any>?
        get() = definedExternally
        set(value) = definedExternally
    var onlyRunForcedResolvers: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$21` {
    var __typename: String
    var id: dynamic /* String | Number */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$22`<TCacheShape> {
    var cache: ApolloCache<TCacheShape>
    var getCacheKey: (obj: `T$21`) -> Any
}

external open class LocalState<TCacheShape>(__0: LocalStateOptions<TCacheShape>) {
    open var cache: Any
    open var client: Any
    open var resolvers: Any
    open var fragmentMatcher: Any
    open fun addResolvers(resolvers: Resolvers)
    open fun addResolvers(resolvers: Array<Resolvers>)
    open fun setResolvers(resolvers: Resolvers)
    open fun setResolvers(resolvers: Array<Resolvers>)
    open fun getResolvers(): Resolvers
    open fun <TData> runResolvers(__0: `T$20`<TData>): Promise<LocalExecutionResult<TData> /* ExecutionResult<TData> & `T$11`<Record<string, any>, Record<string, any>> */>
    open fun setFragmentMatcher(fragmentMatcher: FragmentMatcher)
    open fun getFragmentMatcher(): FragmentMatcher
    open fun clientQuery(document: DocumentNode): DocumentNode?
    open fun serverQuery(document: DocumentNode): DocumentNode?
    open fun prepareContext(context: Any = definedExternally): `T$22`<TCacheShape>
    open fun addExportedVariables(document: DocumentNode, variables: OperationVariables = definedExternally, context: Any = definedExternally): Promise<Json>
//    open fun shouldForceResolvers(document: ASTNode): Boolean
    open var buildRootValueFromCache: Any
    open var resolveDocument: Any
    open var resolveSelectionSet: Any
    open var resolveField: Any
    open var resolveSubSelectedArray: Any
}