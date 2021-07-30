@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package apollo

external enum class NetworkStatus {
    loading /* = 1 */,
    setVariables /* = 2 */,
    fetchMore /* = 3 */,
    refetch /* = 4 */,
    poll /* = 6 */,
    ready /* = 7 */,
    error /* = 8 */
}