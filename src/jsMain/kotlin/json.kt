import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.RProps

val json = Json {
  isLenient = true
  ignoreUnknownKeys = true
  allowSpecialFloatingPointValues = true
  useArrayPolymorphism = true
  allowStructuredMapKeys = true
  encodeDefaults = false
}

fun propsToMap(props: RProps) = json.decodeFromString<Map<String, String>>(JSON.stringify(props))
