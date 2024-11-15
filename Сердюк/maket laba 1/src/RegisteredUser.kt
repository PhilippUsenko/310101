open class RegisteredUser(private var login: String, private val password: String): User() {
    private var isLoggedUser: Boolean = false
    fun login(log: String, pass: String){
        if (log == login && pass == password){
            isLoggedUser = true
            println("Пользователь $login вошёл в систему.")
        }
        else{
            println("Неверный логин или пароль.")
        }
    }
    override fun newMessage(text: String, image: String, forum: Forum)
    {
        if (isLoggedUser){
            val message = Message(text, image)
            forum.addMessage(message)
            println("Сообщение добавлено.")
        }
        else{
            println("Пользователь $login не вошёл в систему.")
        }
    }
    fun isLogged(): Boolean {
        return isLoggedUser
    }

    fun changeLogin(log: String){
        if (isLoggedUser){
            login = log
        }
        else{
            println("Пользователь $login не вошёл в систему.")
        }
    }
    fun getLogin(): String{
        return login
    }
}