package command

import allPhonebook

class Show (val name: String) : Command {
    override fun isValid(): Boolean {
        return true
    }
    override fun execute() {
        if (allPhonebook.isEmpty()) {
            println("Телефонная книга пуста")
        } else if (allPhonebook.containsKey(name)) {
            println(allPhonebook[name])
        } else {
            println("Пользователь с именем $name не обнаружен")
        }
    }
    override fun toString(): String {
        return "Введена команда <show>"
    }
}