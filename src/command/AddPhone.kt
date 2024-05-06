package command

import allPhonebook
import person.Person

class AddPhone(val name: String, val phone: String) : Command {
    val phonePattern1 = Regex("[+]+\\d+")
    val phonePattern2 = Regex("\\d+")
    override fun isValid(): Boolean {
        return phone.matches(phonePattern1) || phone.matches(phonePattern2)
    }

    override fun execute() {
        if(allPhonebook.containsKey(name)){
            allPhonebook[name]?.phones?.add(phone)
        }
        else{
            val person= Person(
                name,
                phones= mutableListOf(phone)
            )
            allPhonebook.put(name,person)
        }
    }

    override fun toString(): String {
        return "Введена команда добавления нового пользователя ${name} с номером телефона ${phone}"
    }
}