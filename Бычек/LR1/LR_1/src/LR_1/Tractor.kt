package LR_1

class Tractor (val name:String, val equipment:String): Car(name){

    fun clearAwaySnow(){
        println("$equipment убирает снег")
    }

    override fun startToGo() {
        println("Машина $name едет")
    }
}