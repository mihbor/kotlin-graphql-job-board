@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import apollo.DataProxy.*
import graphql.DocumentNode
import kotlin.js.Promise

typealias Transaction<T> = (c: ApolloCache<T>) -> Unit

external open class ApolloCache<TSerialized> : DataProxy {
    open fun <T, TVariables> read(query: ReadOptions<TVariables>): T?
    open fun <TResult, TVariables> write(write: WriteOptions<TResult, TVariables>)
    open fun diff(query: DiffOptions): Any?
    open fun watch(watch: WatchOptions): () -> Unit
    open fun <TVariables> evict(query: EvictOptions<TVariables>): EvictionResult
    open fun reset(): Promise<Unit>
    open fun restore(serializedState: TSerialized): ApolloCache<TSerialized>
    open fun extract(optimistic: Boolean = definedExternally): TSerialized
    open fun removeOptimistic(id: String)
    open fun performTransaction(transaction: Transaction<TSerialized>)
    open fun recordOptimisticTransaction(transaction: Transaction<TSerialized>, id: String)
    open fun transformDocument(document: DocumentNode): DocumentNode
    open fun transformForLink(document: DocumentNode): DocumentNode
    override fun <QueryType, TVariables> readQuery(options: Query<TVariables>, optimistic: Boolean): QueryType?
    override fun <FragmentType, TVariables> readFragment(options: Fragment<TVariables>, optimistic: Boolean): FragmentType?
    override fun <QueryType, TVariables> readQuery(options: Query<TVariables>): QueryType?
    override fun <FragmentType, TVariables> readFragment(options: Fragment<TVariables>): FragmentType?
    override fun <TData, TVariables> writeQuery(options: WriteQueryOptions<TData, TVariables>)
    override fun <TData, TVariables> writeFragment(options: WriteFragmentOptions<TData, TVariables>)
    override fun <TData> writeData(__0: WriteDataOptions<TData>)
}