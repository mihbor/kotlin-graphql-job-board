@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package graphql

external interface SourceLocation {
    var line: Number
    var column: Number
}

external open class Source(body: String, name: String = definedExternally, locationOffset: Location = definedExternally) {
    open var body: String
    open var name: String
    open var locationOffset: SourceLocation
}