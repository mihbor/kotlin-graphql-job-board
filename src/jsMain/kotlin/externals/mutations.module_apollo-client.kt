@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import graphql.DocumentNode

external interface `T$24` {
    @nativeGetter
    operator fun get(mutationId: String): MutationStoreValue?
    @nativeSetter
    operator fun set(mutationId: String, value: MutationStoreValue)
}

external open class MutationStore {
    open var store: Any
    open fun getStore(): `T$24`
    open fun get(mutationId: String): MutationStoreValue
    open fun initMutation(mutationId: String, mutation: DocumentNode, variables: Any?)
    open fun markMutationError(mutationId: String, error: Error)
    open fun markMutationResult(mutationId: String)
    open fun reset()
}

external interface MutationStoreValue {
    var mutation: Any
    var variables: Any
    var loading: Boolean
    var error: Error?
}