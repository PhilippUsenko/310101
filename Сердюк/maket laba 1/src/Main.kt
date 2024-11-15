import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)
    val forum = Forum("Любительский форум")
    val userBase = UserBase()

    println("Введите логин администратора")
    val adminLogin = scanner.nextLine()
    println("Введите пароль администратора")
    val adminPassword = scanner.nextLine()
    val admin =  Administrator(adminLogin,adminPassword)
    admin.login(adminLogin, adminPassword)
    var exit = false

    while(!exit){
        println("Выберите действие:")
        println("1. Создать сообщение")
        println("2. Получить список сообщений")
        println("3. Удалить сообщение")
        println("4. Сменить логин")
        println("5. Добавить пользователя")
        println("6. Удалить пользователя")//добавить подтверждение удаления
        println("7. Выйти")

        val choice = scanner.nextLine()
        when(choice){
            "1" -> {
                // Создать сообщение
                if (admin.isLogged()) { // Проверяем, что администратор залогинен
                    println("Введите текст сообщения:")
                    val messageText = scanner.nextLine()
                    println("Введите изображение для сообщения:")
                    val imagePath = scanner.nextLine()
                    admin.newMessage(messageText, imagePath, forum)
                    println("Сообщение создано.")
                } else {
                    println("Администратор не залогинен!")
                }
            }


            "2" -> {
                //  Получить список сообщений
                val messages = forum.getMessages()
                if (messages.isNotEmpty()) {
                    println("Список сообщений:")
                    messages.forEach { message ->
                        println("Сообщение: ${message.line}, Изображение: ${message.image}")
                    }
                } else {
                    println("Сообщений нет.")
                }
            }

            "3" -> {
                //  Удалить сообщение
                println("Введите текст сообщения для удаления:")
                val messageText = scanner.nextLine()
                val messageToDelete = forum.getMessages().find { it.line == messageText }

                if (messageToDelete != null) {
                    admin.deleteMessage(forum, messageToDelete)
                    println("Сообщение удалено.")
                } else {
                    println("Сообщение не найдено.")
                }
            }

            "4" -> {
                //  Сменить логин
                println("Введите новый логин администратора:")
                val newLogin = scanner.nextLine()
                admin.changeUserLogin(admin, newLogin)
            }

            "5" -> {
                //  Добавить пользователя
                println("Введите логин нового пользователя:")
                val userLogin = scanner.nextLine()
                println("Введите пароль нового пользователя:")
                val userPassword = scanner.nextLine()
                val newUser = RegisteredUser(userLogin, userPassword)
                admin.addUserRequest(userBase, newUser)
            }
                // Удалить пользователя
            "6"->{
                // Удалить пользователя
                println("Вы точно хотите удалить пользователя?\n1 - да\n2 - нет")
                val ifdelUser = scanner.nextLine()
                when(ifdelUser){
                    "1"-> {
                        println("Введите логин пользователя для удаления:")
                        val userLogin = scanner.nextLine()
                        val userToDelete =
                            userBase.getUsers().find { it.getLogin() == userLogin } // Поиск пользователя по логину

                        if (userToDelete != null) {
                            admin.deleteUserRequest(userBase, userToDelete) // Удаляем пользователя
                        } else {
                            println("Пользователь с логином '$userLogin' не найден.")
                        }
                    }
                    "2"->{
                        println("Пользователь не был удалён.")
                    }
                }

            }

            "7" -> {
                // Выйти
                exit = true
                println("Выход из программы.")
            }

                else -> {
                  println("Неверная команда.")
                 }
        }
    }
}
