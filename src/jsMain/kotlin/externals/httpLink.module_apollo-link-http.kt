@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("apollo-link-http")
@file:JsNonModule

package apollo

external val createHttpLink: (linkOptions: HttpLink.Options) -> ApolloLink

external open class HttpLink(opts: Options = definedExternally) : ApolloLink {
    open var requester: RequestHandler
    interface Options : HttpOptions {
        var useGETForQueries: Boolean?
            get() = definedExternally
            set(value) = definedExternally
    }
}