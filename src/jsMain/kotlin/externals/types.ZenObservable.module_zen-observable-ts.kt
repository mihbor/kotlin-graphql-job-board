@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package ZenObservable

external interface SubscriptionObserver<T> {
    var closed: Boolean
    fun next(value: T)
    fun error(errorValue: Any)
    fun complete()
}

external interface Subscription {
    var closed: Boolean
    fun unsubscribe()
}

external interface Observer<T> {
    val start: ((subscription: Subscription) -> Any)?
    val next: ((value: T) -> Unit)?
    val error: ((errorValue: Any) -> Unit)?
    val complete: (() -> Unit)?
}

typealias Subscriber<T> = (observer: SubscriptionObserver<T>) -> dynamic

external interface ObservableLike<T> {
    var subscribe: Subscriber<T>?
        get() = definedExternally
        set(value) = definedExternally
}