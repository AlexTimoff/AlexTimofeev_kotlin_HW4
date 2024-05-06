package command

import allPhonebook
import person.Person


class AddEmail(val name: String, val email: String) : Command {
    val emailPattern = Regex("[a-zA-z0-9]+@[a-zA-z0-9]+[.]([a-zA-z0-9]{2,4})")
    override fun isValid(): Boolean {
        return email.matches(emailPattern)
    }

    override fun execute() {
        if(allPhonebook.containsKey(name)){
            allPhonebook[name]?.emails?.add(email)
        }
        else{
            val person= Person(
                name,
                emails= mutableListOf(email)
            )
            allPhonebook.put(name,person)
        }
    }

    override fun toString(): String {
        return "Введена команда добавления нового пользователя ${name} с электронной почтой ${email}"
    }
}