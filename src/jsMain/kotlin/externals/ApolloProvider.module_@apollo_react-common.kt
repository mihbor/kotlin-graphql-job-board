@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsModule("react-apollo")
@file:JsNonModule

package apollo.react

import react.FunctionalComponent

external interface ApolloProviderProps {
    var client: Any
    var children: dynamic /* React.ReactNode? | Array<React.ReactNode>? */
        get() = definedExternally
        set(value) = definedExternally
}

external var ApolloProvider: FunctionalComponent<ApolloProviderProps>