@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import ZenObservable.Observable
import ZenObservable.Observer
import graphql.DocumentNode
import tsstdlib.Readonly
import tsstdlib.Record
import kotlin.js.Promise

external interface `T$7`<TStore> {
    var link: ApolloLink
    var queryDeduplication: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var store: DataStore<TStore>
    var onBroadcast: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var ssrMode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var clientAwareness: Record<String, String>?
        get() = definedExternally
        set(value) = definedExternally
    var localState: LocalState<TStore>?
        get() = definedExternally
        set(value) = definedExternally
    var assumeImmutableResults: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$8` {
    var document: Readonly<DocumentNode>
    var hasClientExports: Boolean
    var hasForcedResolvers: Boolean
    var clientQuery: Readonly<DocumentNode>?
    var serverQuery: Readonly<DocumentNode>?
    var defaultVars: Readonly<OperationVariables>
}

external interface `T$9`<T> {
    var data: T?
    var partial: Boolean
}

external interface `T$10`<TVariables> {
    var previousResult: Any
    var variables: TVariables?
    var document: Any
}

external open class QueryManager<TStore>(__0: `T$7`<TStore>) {
    open var link: ApolloLink
    open var mutationStore: MutationStore
    open var queryStore: QueryStore
    open var dataStore: DataStore<TStore>
    open var assumeImmutableResults: Boolean
    open var queryDeduplication: Any
    open var clientAwareness: Any
    open var localState: Any
    open var onBroadcast: Any
    open var ssrMode: Any
    open var idCounter: Any
    open var queries: Any
    open var fetchQueryRejectFns: Any
    open fun stop()
    open fun <T> mutate(__0: MutationOptions__0): Promise<LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */>
    open fun <T> fetchQuery(queryId: String, options: WatchQueryOptions__0, fetchType: FetchType = definedExternally, fetchMoreForQueryId: String = definedExternally): Promise<LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */>
    open var markQueryResult: Any
    open fun <T> queryListenerForObserver(queryId: String, options: WatchQueryOptions__0, observer: Observer<ApolloQueryResult<T>>): QueryListener
    open var transformCache: Any
    open fun transform(document: DocumentNode): Readonly<`T$8`>
    open var getVariables: Any
    open fun <T, TVariables> watchQuery(options: WatchQueryOptions__0, shouldSubscribe: Boolean = definedExternally): ObservableQuery<T, TVariables>
    open fun <T> query(options: QueryOptions__0): Promise<ApolloQueryResult<T>>
    open fun generateQueryId(): String
    open fun stopQueryInStore(queryId: String)
    open var stopQueryInStoreNoBroadcast: Any
    open fun addQueryListener(queryId: String, listener: QueryListener)
    open fun updateQueryWatch(queryId: String, document: DocumentNode, options: WatchQueryOptions__0): () -> Unit
    open fun <T> addObservableQuery(queryId: String, observableQuery: ObservableQuery__1<T>)
    open fun removeObservableQuery(queryId: String)
    open fun clearStore(): Promise<Unit>
    open fun resetStore(): Promise<Array<ApolloQueryResult<Any>>>
    open fun reFetchObservableQueries(includeStandby: Boolean = definedExternally): Promise<Array<ApolloQueryResult<Any>>>
    open fun <T> observeQuery(queryId: String, options: WatchQueryOptions__0, observer: Observer<ApolloQueryResult<T>>): Promise<LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<String, Any>, Record<String, Any>> */>
    open fun startQuery(queryId: String, options: WatchQueryOptions__0, listener: QueryListener): String
    open fun <T> startGraphQLSubscription(__0: SubscriptionOptions__0): Observable<LocalExecutionResult<T> /* ExecutionResult<T> & `T$11`<Record<string, any>, Record<string, any>> */>
    open fun stopQuery(queryId: String)
    open var stopQueryNoBroadcast: Any
    open fun removeQuery(queryId: String)
    open fun <T> getCurrentQueryResult(observableQuery: ObservableQuery__1<T>, optimistic: Boolean = definedExternally): `T$9`<T>
    open fun <TVariables> getQueryWithPreviousResult(queryIdOrObservable: String): `T$10`<TVariables>
    open fun <TData, TVariables> getQueryWithPreviousResult(queryIdOrObservable: ObservableQuery<TData, TVariables>): `T$10`<TVariables>
    open fun broadcastQueries()
    open fun getLocalState(): LocalState<TStore>
    open var inFlightLinkObservables: Any
    open var getObservableFromLink: Any
    open var fetchRequest: Any
    open var getQuery: Any
    open var setQuery: Any
    open var invalidate: Any
    open var prepareContext: Any
    open fun checkInFlight(queryId: String): Boolean
    open var pollingInfoByQueryId: Any
    open fun startPollingQuery(options: WatchQueryOptions__0, queryId: String, listener: QueryListener = definedExternally): String
    open fun stopPollingQuery(queryId: String)
}