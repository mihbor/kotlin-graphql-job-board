@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import ZenObservable.Observable
import ZenObservable.ObservableLike
import ZenObservable.Observer
import ZenObservable.Subscription
import tsstdlib.ArrayLike
import kotlin.js.Promise

external interface ApolloCurrentResult<T> {
    var data: dynamic /* T | Any */
        get() = definedExternally
        set(value) = definedExternally
    var errors: Array<Error>?
        get() = definedExternally
        set(value) = definedExternally
    var loading: Boolean
    var networkStatus: NetworkStatus
    var error: ApolloError?
        get() = definedExternally
        set(value) = definedExternally
    var partial: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ApolloCurrentQueryResult<T> {
    var data: T?
    var errors: Array<Error>?
        get() = definedExternally
        set(value) = definedExternally
    var loading: Boolean
    var networkStatus: NetworkStatus
    var error: ApolloError?
        get() = definedExternally
        set(value) = definedExternally
    var partial: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var stale: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$0`<TData, TVariables> {
    var fetchMoreResult: TData?
        get() = definedExternally
        set(value) = definedExternally
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FetchMoreOptions<TData, TVariables> {
    var updateQuery: (previousQueryResult: TData, options: `T$0`<Any?, Any?>) -> TData
}

external interface UpdateQueryOptions<TVariables> {
    var variables: TVariables?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$1`<TVariables> {
    var queryManager: QueryManager<Any>
    var options: WatchQueryOptions<TVariables>
    var shouldSubscribe: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class ObservableQuery<TData, TVariables>(__0: `T$1`<TVariables>) : Observable<ApolloQueryResult<TData>> {
    open var options: WatchQueryOptions<TVariables>
    open var queryId: String
    open var queryName: String
    open var variables: TVariables
    open var shouldSubscribe: Any
    open var isTornDown: Any
    open var queryManager: Any
    open var observers: Any
    open var subscriptions: Any
    open var lastResult: Any
    open var lastResultSnapshot: Any
    open var lastError: Any
    open fun result(): Promise<ApolloQueryResult<TData>>
    open fun currentResult(): ApolloCurrentResult<TData>
    open fun getCurrentResult(): ApolloCurrentQueryResult<TData>
    open fun isDifferentFromLastResult(newResult: ApolloQueryResult<TData>): Boolean
    open fun getLastResult(): ApolloQueryResult<TData>
    open fun getLastError(): ApolloError
    open fun resetLastResults()
    open fun resetQueryStoreErrors()
    open fun refetch(variables: TVariables = definedExternally): Promise<ApolloQueryResult<TData>>
    open fun <K : Any> fetchMore(fetchMoreOptions: FetchMoreQueryOptions<TVariables, K> /* FetchMoreQueryOptions<TVariables, K> & FetchMoreOptions<TData, TVariables> */): Promise<ApolloQueryResult<TData>>
    open fun <TSubscriptionData, TSubscriptionVariables> subscribeToMore(options: SubscribeToMoreOptions<TData, TSubscriptionVariables, TSubscriptionData>): () -> Unit
    open fun setOptions(opts: WatchQueryOptions__0): Promise<dynamic /* ApolloQueryResult<TData> | Unit */>
    open fun setVariables(variables: TVariables, tryFetch: Boolean = definedExternally, fetchResults: Boolean = definedExternally): Promise<dynamic /* ApolloQueryResult<TData> | Unit */>
    open fun <TVars> updateQuery(mapFn: (previousQueryResult: TData, options: UpdateQueryOptions<TVars>) -> TData)
    open fun stopPolling()
    open fun startPolling(pollInterval: Number)
    open var updateLastResult: Any
    open var onSubscribe: Any
    open var setUpQuery: Any
    open var tearDownQuery: Any
    override fun subscribe(
        observerOrNext: (value: ApolloQueryResult<TData>) -> Unit,
        error: (error: Any) -> Unit,
        complete: () -> Unit
    ): Subscription
    override fun subscribe(observerOrNext: (value: ApolloQueryResult<TData>) -> Unit): Subscription
    override fun subscribe(
        observerOrNext: (value: ApolloQueryResult<TData>) -> Unit,
        error: (error: Any) -> Unit
    ): Subscription

    override fun subscribe(
        observerOrNext: Observer<ApolloQueryResult<TData>>,
        error: (error: Any) -> Unit,
        complete: () -> Unit
    ): Subscription

    override fun subscribe(observerOrNext: Observer<ApolloQueryResult<TData>>): Subscription

    override fun subscribe(
        observerOrNext: Observer<ApolloQueryResult<TData>>,
        error: (error: Any) -> Unit
    ): Subscription

    override fun forEach(fn: (value: ApolloQueryResult<TData>) -> Unit): Promise<Unit>

    override fun <R> map(fn: (value: ApolloQueryResult<TData>) -> R): Observable<R>

    override fun filter(fn: (value: ApolloQueryResult<TData>) -> Boolean): Observable<ApolloQueryResult<TData>>

    override fun <R> reduce(
        fn: (previousValue: Any?, currentValue: ApolloQueryResult<TData>) -> Any?,
        initialValue: R
    ): Observable<dynamic>

    override fun reduce(fn: (previousValue: Any?, currentValue: ApolloQueryResult<TData>) -> Any?): Observable<dynamic>

    override fun reduce(
        fn: (previousValue: Any?, currentValue: ApolloQueryResult<TData>) -> Any?,
        initialValue: ApolloQueryResult<TData>
    ): Observable<dynamic>

    override fun <R> flatMap(fn: (value: ApolloQueryResult<TData>) -> ObservableLike<R>): Observable<R>

    override fun <R> from(observable: Observable<R>): Observable<R>

    override fun <R> from(observable: ObservableLike<R>): Observable<R>

    override fun <R> from(observable: ArrayLike<R>): Observable<R>

    override fun <R> of(vararg args: R): Observable<R>
}

external open class ObservableQuery__1<TData> : ObservableQuery<TData, OperationVariables>