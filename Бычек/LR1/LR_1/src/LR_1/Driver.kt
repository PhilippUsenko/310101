package LR_1

class Driver (
    private val car: Car,
    val wheel: Wheel,
    val corpus: Corpus
) {

    fun driveCar(){
        println("Управлять автомобилем")
    }

    fun inflateTheWheel(){
        if (wheel.defl==false) {
            println("Колесо сдуто. Надуть колесо")
        }
        wheel.defl = true
        println("Колесо надуто")
    }

    fun go(){
        car.startToGo()
    }

    fun openDoor(){
        print("Сколько дверей вы хотите открыть?    ")
        while (true) {
            corpus.setAmo(readln().toInt())// = readLine()!!.toInt()
            corpus.getAmo()

            if (corpus.getAmo() > 4) {
                println("Столько дверей у машины нет( Откройте другое кол-во    ")
            }
            else {
                print("${corpus.getAmo()}   ")
                corpus.openDoor()
                break
            }
        }
    }

    fun closeDoor(){
        print("${corpus.getAmo()}   ")
        corpus.closeDoor()
    }


}