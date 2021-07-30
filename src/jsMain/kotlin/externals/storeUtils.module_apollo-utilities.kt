@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

external interface IdValue {
    var type: String /* "id" */
    var id: String
    var generated: Boolean
    var typename: String?
}

external interface JsonValue {
    var type: String /* "json" */
    var json: Any
}

typealias ListValue = Array<IdValue?>