package LR_1

class Fuel(
    massa: Int,
    private var volume: Int,
    var amount:Int
): Detail(massa) {

    fun getVolume():Int{
        return volume
    }
    fun setVolume(newVolume: Int){
        volume = newVolume
    }

    fun applyFuel(){
        println("Топливо подается")
    }

    override val detail: Car
        get() = TODO("Not yet implemented")

    fun getNumber(): Int {
        while (true) {
            print("Введите массу топливного бака: ")
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
        println("Топливный бак машины массой   $massa кг ")
    }
}
