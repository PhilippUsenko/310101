class Administrator(
    username: String,
    password: String
) : RegisteredUser(
    username,
    password
) {
    fun deleteMessage(forum: Forum, message: Message) {
        val messages = forum.getMessages().toMutableList()
        if (messages.contains(message)) {
            messages.remove(message)
            println("Сообщение '${message.line}' с изображением '${message.image}' было удалено с форума '${forum.getName()}' администратором ${getLogin()}.")

            // Обновляем оригинальный список сообщений
            forum.setMessages(messages) // Добавьте метод setMessages в класс Forum
        } else {
            println("Сообщение не найдено на форуме.")
        }
    }

    fun deleteUserRequest(userBase: UserBase, user: RegisteredUser) {
        userBase.receiveDeleteRequest(this, user)
    }

    fun addUserRequest(userBase: UserBase, user: RegisteredUser) {
        userBase.receiveAddRequest(this, user)
        println("Пользователь '${user.getLogin()}' был добавлен администратором ${getLogin()}.")
    }

    fun changeUserLogin(user: RegisteredUser, newUsername: String) {
        user.changeLogin(newUsername)
        println("Логин пользователя был изменён на $newUsername администратором ${getLogin()}.")
    }
}