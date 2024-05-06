package jsonMaker

class JsonMaker {
    private val obj = mutableMapOf<String, Any>()

    fun addPersonalGroup(key: String, value: Any) {
        obj[key] = value
    }

    override fun toString(): String {
        val res = obj.entries.joinToString(",\n    ") { (key, value) ->
            if (value is String) {
                "\"$key\": \"$value\""
            } else if (value is List<*> && value.size >= 1) {
                "\"$key\": [\n  ${value.joinToString(",\n  ") { data -> "${if (data is String) "    \"$data\"" else data}" }}\n    ]"
            } else if (value is List<*>) {
                "\"$key\": []"
            } else {
                "\"$key\": $value"
            }
        }
        return "\n  {\n    $res\n  }\n"
    }

}