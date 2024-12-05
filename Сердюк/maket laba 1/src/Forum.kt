class Forum (private val name: String){
    private val messages = mutableListOf<Message>() // Список сообшений
    fun addMessage(message: Message){
        messages.add(message)
    }
    fun getMessages():List<Message>{
        return messages
    }
    fun setMessages(newMessages:List<Message>){
        messages.clear() // Очищаем старый список
        messages.addAll(newMessages) // Добавляем новые сообщения
    }
    fun getName():String{
        return name
    }
}