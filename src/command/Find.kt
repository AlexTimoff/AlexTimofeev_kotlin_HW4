package command

import allPhonebook
import person.Person



class Find (val contact: String): Command {
    override fun isValid(): Boolean {
        return true
    }
    override fun execute() {
        val people = allPhonebook.filter {
            it.value.phones.contains(contact) || it.value.emails.contains(contact)
        }
        if (people.isEmpty()) {
            println("Пользователь с $contact не обнаружен")
        }else{
            println("Обнаружены пользователи с $contact :")
            for (person in people){
                println(person.value)
            }
        }
    }
    override fun toString(): String {
        return "Введена команда <find>"
    }
}