@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import kotlin.js.Json

external interface IdGetterObj {
    var __typename: String?
        get() = definedExternally
        set(value) = definedExternally
    var id: String?
        get() = definedExternally
        set(value) = definedExternally
}

typealias IdGetter = (value: IdGetterObj) -> String?

external interface NormalizedCache {
    fun get(dataId: String): StoreObject
    fun set(dataId: String, value: StoreObject)
    fun delete(dataId: String)
    fun clear()
    fun toObject(): NormalizedCacheObject
    fun replace(newData: NormalizedCacheObject)
}

external interface NormalizedCacheObject {
    @nativeGetter
    operator fun get(dataId: String): StoreObject?
    @nativeSetter
    operator fun set(dataId: String, value: StoreObject?)
}

external interface StoreObject {
    var __typename: String?
        get() = definedExternally
        set(value) = definedExternally
    @nativeGetter
    operator fun get(storeFieldKey: String): dynamic /* Number? | String? | Array<String>? | IdValue? | ListValue? | JsonValue? | Unit? | Object? */
    @nativeSetter
    operator fun set(storeFieldKey: String, value: Number?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: String?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: Array<String>?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: IdValue?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: ListValue?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: JsonValue?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: Unit?)
    @nativeSetter
    operator fun set(storeFieldKey: String, value: Any?)
}

external interface OptimisticStoreItem {
    var id: String
    var data: NormalizedCacheObject
    var transaction: Transaction<NormalizedCacheObject>
}

external interface ReadQueryOptions {
    var store: NormalizedCache
    var query: Any
    var fragmentMatcherFunction: FragmentMatcher?
        get() = definedExternally
        set(value) = definedExternally
    var variables: Any?
        get() = definedExternally
        set(value) = definedExternally
    var previousResult: Any?
        get() = definedExternally
        set(value) = definedExternally
    var rootId: String?
        get() = definedExternally
        set(value) = definedExternally
    var config: ApolloReducerConfig?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ApolloReducerConfig {
    var dataIdFromObject: IdGetter?
        get() = definedExternally
        set(value) = definedExternally
    var fragmentMatcher: FragmentMatcherInterface?
        get() = definedExternally
        set(value) = definedExternally
    var addTypename: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var cacheRedirects: CacheResolverMap?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ReadStoreContext {
    var store: NormalizedCache
    var cacheRedirects: CacheResolverMap
    var dataIdFromObject: IdGetter?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FragmentMatcherInterface {
    fun match(idValue: IdValue, typeCondition: String, context: ReadStoreContext): dynamic /* Boolean | "heuristic" */
}

external interface PossibleTypesMap {
    @nativeGetter
    operator fun get(key: String): Array<String>?
    @nativeSetter
    operator fun set(key: String, value: Array<String>)
}

external interface `T$27` {
    var name: String
}

external interface `T$28` {
    var kind: String
    var name: String
    var possibleTypes: Array<`T$27`>
}

external interface `T$29` {
    var types: Array<`T$28`>
}

external interface IntrospectionResultData {
    var __schema: `T$29`
}

typealias CacheResolver = (rootValue: Any, args: Json, context: Any) -> Any

external interface `T$30` {
    @nativeGetter
    operator fun get(fieldName: String): CacheResolver?
    @nativeSetter
    operator fun set(fieldName: String, value: CacheResolver)
}

external interface CacheResolverMap {
    @nativeGetter
    operator fun get(typeName: String): `T$30`?
    @nativeSetter
    operator fun set(typeName: String, value: `T$30`)
}

typealias CustomResolver = CacheResolver

typealias CustomResolverMap = CacheResolverMap