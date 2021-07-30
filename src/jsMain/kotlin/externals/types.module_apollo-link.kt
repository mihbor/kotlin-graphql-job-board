@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

import ZenObservable.Observable
import tsstdlib.Record

external interface LocalExecutionResult<TData> {
    var data: TData?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GraphQLRequest {
    var query: Any
    var variables: Record<String, Any>?
        get() = definedExternally
        set(value) = definedExternally
    var operationName: String?
        get() = definedExternally
        set(value) = definedExternally
    var context: Record<String, Any>?
        get() = definedExternally
        set(value) = definedExternally
    var extensions: Record<String, Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Operation {
    var query: Any
    var variables: Record<String, Any>
    var operationName: String
    var extensions: Record<String, Any>
    var setContext: (context: Record<String, Any>) -> Record<String, Any>
    var getContext: () -> Record<String, Any>
    var toKey: () -> String
}

typealias NextLink = (operation: Operation) -> Observable<LocalExecutionResult<dynamic> /* ExecutionResult<dynamic> & `T$0`<Record<string, any>, Record<string, any>> */>

typealias RequestHandler = (operation: Operation, forward: NextLink) -> Observable<LocalExecutionResult<dynamic> /* ExecutionResult<dynamic> & `T$0`<Record<string, any>, Record<string, any>> */>?