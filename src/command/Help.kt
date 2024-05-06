package command


class Help : Command {
    override fun isValid(): Boolean {
        return true
    }
    override fun execute() {
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        println("help - вывод информации о доступных командах.")
        println("add <User> phone <UserPhone> - добавление контакта с номером телефона, " +
                "а также добавление нового номера телефона к уже существующему контакту.")
        println("add <User> email <UserEmail> - добавление контакта с электронной почтой, " +
                "а также добавление нового эл. адреса к уже существующему контакту.")
        println("show <User> - вывод списка телефонов и эл. адресов пользователя.")
        println("find <Contact> - вывод всех контактов по заданному номеру телефона или адресу эл. почты.")
        println("print - вывод всех сохраненных контактов.")
        println("export </path/file.json> - экспорт телефонной книги в в текстовый файл file.json.")
        println("exit - выход из приложения.")
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    }
    override fun toString(): String {
        return "Вывод справочной информации о работе приложения"
    }

}