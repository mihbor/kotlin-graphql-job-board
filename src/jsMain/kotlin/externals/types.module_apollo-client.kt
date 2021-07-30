@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import tsstdlib.Record
import kotlin.js.Json

typealias QueryListener = (queryStoreValue: QueryStoreValue, newData: Any, forceResolvers: Boolean) -> Unit

external interface OperationVariables {
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
}

external interface PureQueryOptions {
    var query: Any
    var variables: Json?
        get() = definedExternally
        set(value) = definedExternally
    var context: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ApolloQueryResult<T> {
    var data: T
    var errors: Array<GraphQLError>?
        get() = definedExternally
        set(value) = definedExternally
    var loading: Boolean
    var networkStatus: NetworkStatus
    var stale: Boolean
}

external enum class FetchType {
    normal /* = 1 */,
    refetch /* = 2 */,
    poll /* = 3 */
}

external interface `T$19`<T> {
    var mutationResult: LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */
    var queryName: String?
    var queryVariables: Record<String, Any>
}

typealias MutationQueryReducer<T> = (previousResult: Record<String, Any>, options: `T$19`<T>) -> Record<String, Any>

external interface MutationQueryReducersMap<T> {
    @nativeGetter
    operator fun get(queryName: String): MutationQueryReducer<T>?
    @nativeSetter
    operator fun set(queryName: String, value: MutationQueryReducer<T>)
}

external interface `T$18` {
    @nativeGetter
    operator fun get(field: String): Resolver?
    @nativeSetter
    operator fun set(field: String, value: Resolver)
}

external interface Resolvers {
    @nativeGetter
    operator fun get(key: String): `T$18`?
    @nativeSetter
    operator fun set(key: String, value: `T$18`)
}