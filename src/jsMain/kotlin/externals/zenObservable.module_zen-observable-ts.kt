@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package ZenObservable

import tsstdlib.ArrayLike
import kotlin.js.Promise

external interface Observable<T> {
    fun subscribe(observerOrNext: (value: T) -> Unit, error: (error: Any) -> Unit = definedExternally, complete: () -> Unit = definedExternally): Subscription
    fun subscribe(observerOrNext: (value: T) -> Unit): Subscription
    fun subscribe(observerOrNext: (value: T) -> Unit, error: (error: Any) -> Unit = definedExternally): Subscription
    fun subscribe(observerOrNext: Observer<T>, error: (error: Any) -> Unit = definedExternally, complete: () -> Unit = definedExternally): Subscription
    fun subscribe(observerOrNext: Observer<T>): Subscription
    fun subscribe(observerOrNext: Observer<T>, error: (error: Any) -> Unit = definedExternally): Subscription
    fun forEach(fn: (value: T) -> Unit): Promise<Unit>
    fun <R> map(fn: (value: T) -> R): Observable<R>
    fun filter(fn: (value: T) -> Boolean): Observable<T>
    fun <R> reduce(fn: (previousValue: Any? /* R | T */, currentValue: T) -> Any?, initialValue: R = definedExternally): Observable<dynamic /* R | T */>
    fun reduce(fn: (previousValue: Any? /* R | T */, currentValue: T) -> Any?): Observable<dynamic /* R | T */>
    fun reduce(fn: (previousValue: Any? /* R | T */, currentValue: T) -> Any?, initialValue: T = definedExternally): Observable<dynamic /* R | T */>
    fun <R> flatMap(fn: (value: T) -> ObservableLike<R>): Observable<R>
    fun <R> from(observable: Observable<R>): Observable<R>
    fun <R> from(observable: ObservableLike<R>): Observable<R>
    fun <R> from(observable: ArrayLike<R>): Observable<R>
    fun <R> of(vararg args: R): Observable<R>
}