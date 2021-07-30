@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo.react

import global.JSX.Element

external fun <TData, TVariables> Query(props: QueryComponentOptions<TData, TVariables>): Element?