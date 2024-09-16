package LR_1

class Wheel(
    override var massa:Int,
    var defl:Boolean
): Detail(massa){

    fun rolate(){
        println("Колесо вращается")
    }

    override val detail: Car
        get() = TODO("Not yet implemented")


    fun getNumber(): Int {
        while (true) {
            print("Введите массу колеса: ")
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
        println("Колеса массой ${massa * 4}  кг")
    }
}