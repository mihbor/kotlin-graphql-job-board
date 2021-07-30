@file:JsModule("graphql-tag")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package graphql

@JsName("default")
external fun gql(literals: String, vararg args: Any): DocumentNode

@JsName("default")
external fun gql(literals: Array<String>, vararg args: Any): DocumentNode