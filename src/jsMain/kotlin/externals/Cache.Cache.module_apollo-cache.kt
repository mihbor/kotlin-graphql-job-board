@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package apollo

import apollo.DataProxy.Query

typealias WatchCallback = (newData: Any) -> Unit

external interface EvictionResult {
    var success: Boolean
}

external interface ReadOptions<TVariables> : Query<TVariables> {
    var rootId: String?
        get() = definedExternally
        set(value) = definedExternally
    var previousResult: Any?
        get() = definedExternally
        set(value) = definedExternally
    var optimistic: Boolean
}

external interface ReadOptions__0 : ReadOptions<Any>

external interface WriteOptions<TResult, TVariables> : Query<TVariables> {
    var dataId: String
    var result: TResult
}

external interface WriteOptions__0 : WriteOptions<Any, Any>

external interface DiffOptions : ReadOptions__0 {
    var returnPartialData: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WatchOptions : ReadOptions__0 {
    var callback: WatchCallback
}

external interface EvictOptions<TVariables> : Query<TVariables> {
    var rootId: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EvictOptions__0 : EvictOptions<Any>