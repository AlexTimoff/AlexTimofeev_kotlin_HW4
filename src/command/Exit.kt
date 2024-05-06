package command

import kotlin.system.exitProcess

class Exit : Command {
    override fun isValid(): Boolean {
        return true
    }
    override fun execute() {
        println("До свидания!")
        exitProcess(0)
    }
    override fun toString(): String {
        return "Введена команда <exit>"
    }
}