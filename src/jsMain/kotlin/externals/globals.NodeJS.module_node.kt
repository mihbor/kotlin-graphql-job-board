@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package NodeJS

external interface InspectOptions {
    var getters: dynamic /* "get" | "set" | Boolean? */
        get() = definedExternally
        set(value) = definedExternally
    var showHidden: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var depth: Number?
        get() = definedExternally
        set(value) = definedExternally
    var colors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var customInspect: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showProxy: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var maxArrayLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var maxStringLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var breakLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var compact: dynamic /* Boolean? | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var sorted: dynamic /* Boolean? | ((a: String, b: String) -> Number)? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface CallSite {
    fun getThis(): Any
    fun getTypeName(): String?
    fun getFunction(): Function<*>?
    fun getFunctionName(): String?
    fun getMethodName(): String?
    fun getFileName(): String?
    fun getLineNumber(): Number?
    fun getColumnNumber(): Number?
    fun getEvalOrigin(): String?
    fun isToplevel(): Boolean
    fun isEval(): Boolean
    fun isNative(): Boolean
    fun isConstructor(): Boolean
}

typealias ErrnoException = Error

external interface `T$5` {
    var end: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}
/*
external interface ReadableStream : EventEmitter {
    var readable: Boolean
    fun read(size: Number = definedExternally): dynamic *//* String | Buffer *//*
    fun setEncoding(encoding: BufferEncoding): ReadableStream *//* this *//*
    fun pause(): ReadableStream *//* this *//*
    fun resume(): ReadableStream *//* this *//*
    fun isPaused(): Boolean
    fun <T : WritableStream> pipe(destination: T, options: `T$5` = definedExternally): T
    fun unpipe(destination: WritableStream = definedExternally): ReadableStream *//* this *//*
    fun unshift(chunk: String, encoding: BufferEncoding = definedExternally)
    fun unshift(chunk: String)
    fun unshift(chunk: Uint8Array, encoding: BufferEncoding = definedExternally)
    fun unshift(chunk: Uint8Array)
    fun wrap(oldStream: ReadableStream): ReadableStream *//* this *//*
}

external interface WritableStream : EventEmitter {
    var writable: Boolean
    fun write(buffer: Uint8Array, cb: (err: Error?) -> Unit = definedExternally): Boolean
    fun write(buffer: Uint8Array): Boolean
    fun write(buffer: String, cb: (err: Error?) -> Unit = definedExternally): Boolean
    fun write(buffer: String): Boolean
    fun write(str: String, encoding: BufferEncoding = definedExternally, cb: (err: Error?) -> Unit = definedExternally): Boolean
    fun write(str: String, encoding: BufferEncoding = definedExternally): Boolean
    fun end(cb: () -> Unit = definedExternally)
    fun end()
    fun end(data: String, cb: () -> Unit = definedExternally)
    fun end(data: String)
    fun end(data: Uint8Array, cb: () -> Unit = definedExternally)
    fun end(data: Uint8Array)
    fun end(str: String, encoding: BufferEncoding = definedExternally, cb: () -> Unit = definedExternally)
    fun end(str: String, encoding: BufferEncoding = definedExternally)
}

external interface ReadWriteStream : ReadableStream, WritableStream

external interface Global {
    var AbortController: Any
    var AbortSignal: Any
    var Array: Any
    var ArrayBuffer: Any
    var Boolean: Any
    var Buffer: Any
    var DataView: Any
    var Date: Any
    var Error: Any
    var EvalError: Any
    var Float32Array: Any
    var Float64Array: Any
    var Function: Any
    var Infinity: Any
    var Int16Array: Any
    var Int32Array: Any
    var Int8Array: Any
    var Intl: Any
    var JSON: Any
    var Map: Any
    var Math: Any
    var NaN: Any
    var Number: Any
    var Object: Any
    var Promise: Any
    var RangeError: Any
    var ReferenceError: Any
    var RegExp: Any
    var Set: Any
    var String: Any
    var Symbol: Function<*>
    var SyntaxError: Any
    var TypeError: Any
    var URIError: Any
    var Uint16Array: Any
    var Uint32Array: Any
    var Uint8Array: Any
    var Uint8ClampedArray: Any
    var WeakMap: Any
    var WeakSet: Any
    var clearImmediate: (immediateId: Immediate) -> Unit
    var clearInterval: (intervalId: Timeout) -> Unit
    var clearTimeout: (timeoutId: Timeout) -> Unit
    var decodeURI: Any
    var decodeURIComponent: Any
    var encodeURI: Any
    var encodeURIComponent: Any
    var escape: (str: String) -> String
    var eval: Any
    var global: Global
    var isFinite: Any
    var isNaN: Any
    var parseFloat: Any
    var parseInt: Any
    var setImmediate: (callback: (args: Any) -> Unit, args: Any) -> Immediate
    var setInterval: (callback: (args: Any) -> Unit, ms: Number, args: Any) -> Timeout
    var setTimeout: (callback: (args: Any) -> Unit, ms: Number, args: Any) -> Timeout
    var queueMicrotask: Any
    var undefined: Any
    var unescape: (str: String) -> String
    var gc: () -> Unit
    var v8debug: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RefCounted {
    fun ref(): RefCounted *//* this *//*
    fun unref(): RefCounted *//* this *//*
}

external interface Timer : RefCounted {
    fun hasRef(): Boolean
    fun refresh(): Timer *//* this *//*
}

external interface Immediate : RefCounted {
    fun hasRef(): Boolean
    var _onImmediate: Function<*>
}

external interface Timeout : Timer {
    override fun hasRef(): Boolean
    override fun refresh(): Timeout *//* this *//*
}

external interface Require {
    @nativeInvoke
    operator fun invoke(id: String): Any
    var resolve: RequireResolve
    var cache: Dict<NodeModule>
    var extensions: RequireExtensions
    var main: Module?
}

external interface `T$6` {
    var paths: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RequireResolve {
    @nativeInvoke
    operator fun invoke(id: String, options: `T$6` = definedExternally): String
    fun paths(request: String): Array<String>?
}

external interface RequireExtensions : Dict<(m: Module, filename: String) -> Any> {
    @nativeGetter
    override operator fun get(key: String): ((m: Module, filename: String) -> Any)?
    @nativeSetter
    operator fun set(key: String, value: (m: Module, filename: String) -> Any)
}

external interface Module {
    var exports: Any
    var require: Require
    var id: String
    var filename: String
    var loaded: Boolean
    var parent: Module?
    var children: Array<Module>
    var path: String
    var paths: Array<String>
}*/

external interface Dict<T> {
    @nativeGetter
    operator fun get(key: String): T?
    @nativeSetter
    operator fun set(key: String, value: T?)
}

external interface ReadOnlyDict<T> {
    @nativeGetter
    operator fun get(key: String): T?
    @nativeSetter
    operator fun set(key: String, value: T?)
}