package person

data class Person (
    var name: String,
    var phones: MutableList<String> = mutableListOf(),
    var emails: MutableList<String> = mutableListOf()
) {
    override fun toString(): String {
        return buildString {
            append("Пользователь: ")
            append(name)
            if(phones.isNotEmpty()){
                append("\n\t")
                append("Номера телефонов: ")
                append(phones)
            }
            if(emails.isNotEmpty()){
                append("\n\t")
                append("Электронные адреса: ")
                append(emails)
            }
        }
    }
}


