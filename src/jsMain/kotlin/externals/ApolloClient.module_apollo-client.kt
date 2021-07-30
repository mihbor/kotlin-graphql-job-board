@file:JsModule("apollo-client")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import ZenObservable.Observable
import apollo.DataProxy.*
import apollo.react.ExecutionResult
import kotlin.js.Promise

external interface DefaultOptions {
    var watchQuery: Any?
        get() = definedExternally
        set(value) = definedExternally
    var query: Any?
        get() = definedExternally
        set(value) = definedExternally
    var mutate: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ApolloClientOptions<TCacheShape> {
    var link: ApolloLink?
        get() = definedExternally
        set(value) = definedExternally
    var cache: ApolloCache<TCacheShape>
    var ssrForceFetchDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var ssrMode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var connectToDevTools: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var queryDeduplication: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var defaultOptions: DefaultOptions?
        get() = definedExternally
        set(value) = definedExternally
    var assumeImmutableResults: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var resolvers: dynamic /* Resolvers? | Array<Resolvers>? */
        get() = definedExternally
        set(value) = definedExternally
    var typeDefs: dynamic /* String? | Array<String>? | DocumentNode? | Array<DocumentNode>? */
        get() = definedExternally
        set(value) = definedExternally
    var fragmentMatcher: FragmentMatcher?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var version: String?
        get() = definedExternally
        set(value) = definedExternally
}

@JsName("default")
external open class ApolloClient<TCacheShape>(options: ApolloClientOptions<TCacheShape>) : DataProxy {
    open var link: ApolloLink
    open var store: DataStore<TCacheShape>
    open var cache: ApolloCache<TCacheShape>
    open var queryManager: QueryManager<TCacheShape>
    open var disableNetworkFetches: Boolean
    open var version: String
    open var queryDeduplication: Boolean
    open var defaultOptions: DefaultOptions
    open var typeDefs: dynamic /* String | Array<String> | DocumentNode | Array<DocumentNode> */
    open var devToolsHookCb: Any
    open var resetStoreCallbacks: Any
    open var clearStoreCallbacks: Any
    open var localState: Any
    open fun stop()
    open fun <T, TVariables> watchQuery(options: WatchQueryOptions<TVariables>): ObservableQuery<T, TVariables>
    open fun <T, TVariables> query(options: QueryOptions<TVariables>): Promise<ApolloQueryResult<T>>
    open fun <T, TVariables> mutate(options: MutationOptions<T, TVariables>): Promise<LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */>
    open fun <T, TVariables> subscribe(options: SubscriptionOptions<TVariables>): Observable<LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */>
    override fun <T, TVariables> readQuery(options: Query<TVariables>): T?
    override fun <T, TVariables> readFragment(options: Fragment<TVariables>): T?
    override fun <T, TVariables> readQuery(options: Query<TVariables>, optimistic: Boolean): T?
    override fun <T, TVariables> readFragment(options: Fragment<TVariables>, optimistic: Boolean): T?
    override fun <TData, TVariables> writeQuery(options: WriteQueryOptions<TData, TVariables>)
    override fun <TData, TVariables> writeFragment(options: WriteFragmentOptions<TData, TVariables>)
    override fun <TData> writeData(options: WriteDataOptions<TData>)
    open fun __actionHookForDevTools(cb: () -> Any)
    open fun <T> __requestRaw(payload: GraphQLRequest): Observable<ExecutionResult<T>>
    open fun initQueryManager(): QueryManager<TCacheShape>
    open fun resetStore(): Promise<Array<ApolloQueryResult<Any>>?>
    open fun clearStore(): Promise<Array<Any>>
    open fun onResetStore(cb: () -> Promise<Any>): () -> Unit
    open fun onClearStore(cb: () -> Promise<Any>): () -> Unit
    open fun reFetchObservableQueries(includeStandby: Boolean = definedExternally): Promise<Array<ApolloQueryResult<Any>>>
    open fun extract(optimistic: Boolean = definedExternally): TCacheShape
    open fun restore(serializedState: TCacheShape): ApolloCache<TCacheShape>
    open fun addResolvers(resolvers: Resolvers)
    open fun addResolvers(resolvers: Array<Resolvers>)
    open fun setResolvers(resolvers: Resolvers)
    open fun setResolvers(resolvers: Array<Resolvers>)
    open fun getResolvers(): Resolvers
    open fun setLocalStateFragmentMatcher(fragmentMatcher: FragmentMatcher)
}