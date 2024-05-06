package command

import allPhonebook
import jsonMaker.JsonMaker
import java.io.File


class Export(val path: String): Command {
    override fun isValid(): Boolean {
        return true
    }

    override fun execute() {
        if (allPhonebook.isEmpty()){
            println("Телефонная книга пуста")
        } else {
            val personsJson = allPhonebook.values.map{ person -> json{
                addPersonalGroup("name", person.name)
                person.phones?.let{ addPersonalGroup("phone", it) }
                person.emails?.let{ addPersonalGroup("email", it) }
            }
        }
            val jsonFile = "[${personsJson.joinToString(", ")}]"
            File(path).writeText(jsonFile)
            println("JSON-file $path создан")
        }

    }
    fun json(init: JsonMaker.() -> Unit): JsonMaker {
        return JsonMaker().apply(init)
    }
    override fun toString(): String {
        return "Введена команда <export>"
    }
}