package LR_1

class Engine(
    override var massa:Int,
    private val wheel: Wheel,
    val fuel: Fuel
): Detail(massa) {

    fun work(){
        println("Двигатель работает")
    }
    private fun startWork(){
        println("Двигатель завелся")
    }

    fun applyFuel(){
        print("Запросить топливо в количестве ")
        while (true) {
            fuel.amount = readLine()!!.toInt()

            if (fuel.amount >= 20) {
                println("К сожалению, столько топлива подаваться не может. Запросите другое кол-во")
            }
            else {
                println("Из бака объемом ${fuel.getVolume()} л подается топливо в количестве ${fuel.amount} л")
                fuel.applyFuel()
                break
            }
        }
    }

    fun Rolate(){
        println("Двигатель инициирует вращение колеса")
        wheel.rolate()
    }

    override val detail: Car
        get() = TODO("Not yet implemented")


    fun getNumber(): Int {
        while (true) {
            print("Введите массу двигателя: ")
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
        println("Двигатель машины массой  $massa  кг")
    }

    inner class InnerClass{
        fun callPrivatemethod(){
            startWork()
        }
    }
}