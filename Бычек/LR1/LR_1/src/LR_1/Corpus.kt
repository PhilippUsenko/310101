package LR_1

class Corpus(
    override var massa:Int,
    private var amo:Int
): Detail(massa) {

    fun getAmo():Int{
        return amo
    }
    fun setAmo(newAmo: Int){
        amo = newAmo
    }

    fun openDoor(){
        println("Двери открыты")
    }

    fun closeDoor(){
        println("двери вы закрыли")
    }

    override val detail: Car
        get() = TODO("Not yet implemented")

    fun getNumber(): Int {
        while (true) {
            print("Введите массу корпуса: ")
            val userInput = readLine()
            try {
                // Пробуем преобразовать ввод в число
                return userInput?.toInt() ?: throw NumberFormatException()
            } catch (e: NumberFormatException) {
                // Если ввод не числовой, ловим исключение
                println("Ошибка: Введите корректное число.")
            }
        }
    }

    override fun Details() {
        massa = getNumber()
        println("Корпус массой $massa кг")
    }
}