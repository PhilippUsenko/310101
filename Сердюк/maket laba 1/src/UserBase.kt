class UserBase(){

    private val users: MutableList<User> = mutableListOf()

    private fun addUser(user: RegisteredUser){
        if (!users.contains(user)){
            users.add(user)
        }
        else{
            println("Пользователь ${user.getLogin()} уже есть в базе.")
        }
    }

    private fun delUser(user: RegisteredUser){
        if(users.contains(user)){
            users.remove(user)
            println("Пользователь ${user.getLogin()} был удалён из базы.")
        }
        else{
            println("Пользователь ${user.getLogin()} не был найден в базе.")
        }
    }
    fun getUsers():List<RegisteredUser>{
        return users.filterIsInstance<RegisteredUser>() // Фильтруем только RegisteredUser
    }
    fun receiveAddRequest(requester: User, user: RegisteredUser) {
        if (requester is Administrator) {
            println("Администратор ${requester.getLogin()} сделал запрос на добавление пользователя ${user.getLogin()}.")
            addUser(user)
        } else {
            println("Запрос отклонён. Только администратор может создавать запросы.")
        }
    }

    fun receiveDeleteRequest(requester: User, user: RegisteredUser) {
        if (requester is Administrator) {
            println("Администратор ${requester.getLogin()} сделал запрос на удаление пользователя ${user.getLogin()}.")
            delUser(user)
        } else {
            println("Запрос отклонён. Только администратор может создавать запросы.")
        }
    }
}