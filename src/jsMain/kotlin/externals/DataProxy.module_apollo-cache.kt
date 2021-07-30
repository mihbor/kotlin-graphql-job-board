@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface DataProxy {
    fun <QueryType, TVariables> readQuery(options: Query<TVariables>, optimistic: Boolean): QueryType?
    fun <FragmentType, TVariables> readFragment(options: Fragment<TVariables>, optimistic: Boolean): FragmentType?
    fun <QueryType, TVariables> readQuery(options: Query<TVariables>): QueryType?
    fun <FragmentType, TVariables> readFragment(options: Fragment<TVariables>): FragmentType?
    fun <TData, TVariables> writeQuery(options: WriteQueryOptions<TData, TVariables>)
    fun <TData, TVariables> writeFragment(options: WriteFragmentOptions<TData, TVariables>)
    fun <TData> writeData(options: WriteDataOptions<TData>)
    interface Query<TVariables> {
        var query: Any
        var variables: TVariables?
            get() = definedExternally
            set(value) = definedExternally
    }
    interface Fragment<TVariables> {
        var id: String
        var fragment: Any
        var fragmentName: String?
            get() = definedExternally
            set(value) = definedExternally
        var variables: TVariables?
            get() = definedExternally
            set(value) = definedExternally
    }
    interface WriteQueryOptions<TData, TVariables> : Query<TVariables> {
        var data: TData
    }
    interface WriteFragmentOptions<TData, TVariables> : Fragment<TVariables> {
        var data: TData
    }
    interface WriteDataOptions<TData> {
        var data: TData
        var id: String?
            get() = definedExternally
            set(value) = definedExternally
    }
    interface DiffResult<T> {
        var result: T?
            get() = definedExternally
            set(value) = definedExternally
        var complete: Boolean?
            get() = definedExternally
            set(value) = definedExternally
    }
}