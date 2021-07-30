@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

external interface UriFunction {
    @nativeInvoke
    operator fun invoke(operation: Operation): String
}

external interface HttpOptions {
    var uri: dynamic /* String? | UriFunction? */
        get() = definedExternally
        set(value) = definedExternally
    var includeExtensions: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var fetch: Any?
        get() = definedExternally
        set(value) = definedExternally
    var headers: Any?
        get() = definedExternally
        set(value) = definedExternally
    var credentials: String?
        get() = definedExternally
        set(value) = definedExternally
    var fetchOptions: Any?
        get() = definedExternally
        set(value) = definedExternally
}