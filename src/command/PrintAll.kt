package command

import allPhonebook

class PrintAll: Command {
    override fun isValid(): Boolean {
        return true
    }

    override fun execute() {
        for (person in allPhonebook.values) {
            println(person)
            println()
        }
    }
    override fun toString(): String {
        return "Введена команда <print>"
    }
}