import command.*
import person.Person

/*
Домашнее задание №4

Продолжаем дорабатывать домашнее задание из предыдущего семинара. За основу берём код решения из предыдущего домашнего задания.

— Добавьте новую команду export, которая экспортирует добавленные значения в текстовый файл в формате JSON. Команда принимает путь к новому файлу. Например
export /Users/user/myfile.json
— Реализуйте DSL на Kotlin, который позволит конструировать JSON и преобразовывать его в строку.
— Используйте этот DSL для экспорта данных в файл.
— Выходной JSON не обязательно должен быть отформатирован, поля объектов могут идти в любом порядке. Главное, чтобы он имел корректный синтаксис. Такой вывод тоже принимается:
[{""emails"": [""ew@huh.ru""],""name"": ""Alex"",""phones"": [""34355"",""847564""]},{""emails"": [],""name"": ""Tom"",""phones"": [""84755""]}]

Записать текст в файл можно при помощи удобной функции-расширения writeText:
File(""/Users/user/file.txt"").writeText(""Text to write"")

Под капотом она использует такую конструкцию


FileOutputStream(file).use {
it.write(text.toByteArray(Charsets.UTF_8))
}
 */

fun main() {

    println("Введите команду соответсвующую команду или <help> для вывода списка команд на экран ")
    while (true) {
        val command: Command = readCommand()
        if (command.isValid()) {
            println(command)
            command.execute()
        } else {
            error()
            Help()
        }
    }
}

var allPhonebook = mutableMapOf<String, Person>()

fun readCommand(): Command {
    print (">>>>")
    var userInput: String = ""
    userInput = readLine().toString()
    val words: List <String> = userInput.split(' ')
    return when (words[0]){
        "add"->{
            if(words.size==4 &&words[2].contains("phone")){
                AddPhone(words[1],words[3])
            }
            else if (words.size==4 &&words[2].contains("email")) {
                AddEmail(words[1], words[3])
            }
            else{
                error()
                return Help()
            }
        }
        "help"->{
            if(words.size==1){
                Help()
            }
            else{
                error()
                return Help()
            }
        }
        "print"->{
            if(words.size==1){
                PrintAll()
            }
            else{
                error()
                return Help()
            }
        }

        "exit"->{
            if(words.size==1){
                Exit()
            }
            else{
                error()
                return Help()
            }
        }
        "show"->{
            if(words.size==2){
                Show(words[1])
            }
            else{
                error()
                return Help()
            }
        }

        "find"->{
            if(words.size==2){
                Find(words[1])
            }
            else{
                error()
                return Help()
            }
        }

        "export" -> {
            if(words.size==2){
                Export(words[1])
            }
            else{
                error()
                return Help()
            }
        }

        else->{
            error()
            return Help()
        }
    }
}


fun error(){
    println("Введена некорректная команда! Попробуйте снова!")
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
}



