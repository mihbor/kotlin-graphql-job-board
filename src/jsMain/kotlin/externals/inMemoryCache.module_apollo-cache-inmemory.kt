@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("apollo-cache-inmemory")
@file:JsNonModule

package apollo

import graphql.DocumentNode
import kotlin.js.Promise

external interface InMemoryCacheConfig : ApolloReducerConfig {
    var resultCaching: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var freezeResults: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun defaultDataIdFromObject(result: Any): String?

external open class InMemoryCache(config: InMemoryCacheConfig = definedExternally) : ApolloCache<NormalizedCacheObject> {
    open var data: Any
    open var optimisticData: Any
    open var config: InMemoryCacheConfig
    open var watches: Any
    open var addTypename: Any
    open var typenameDocumentCache: Any
    open var storeReader: Any
    open var storeWriter: Any
    open var cacheKeyRoot: Any
    open var silenceBroadcast: Any
    override fun restore(data: NormalizedCacheObject): InMemoryCache /* this */
    override fun extract(optimistic: Boolean): NormalizedCacheObject
    open fun <T> read(options: ReadOptions__0): T?
    open fun write(write: WriteOptions__0)
    override fun diff(query: DiffOptions): Any?
    override fun watch(watch: WatchOptions): () -> Unit
    open fun evict(query: EvictOptions__0): EvictionResult
    override fun reset(): Promise<Unit>
    override fun removeOptimistic(idToRemove: String)
    open fun performTransaction(transaction: Transaction<NormalizedCacheObject>, optimisticId: String = definedExternally)
    override fun recordOptimisticTransaction(transaction: Transaction<NormalizedCacheObject>, id: String)
    override fun transformDocument(document: DocumentNode): DocumentNode
    open fun broadcastWatches()
    open var maybeBroadcastWatch: Any
}