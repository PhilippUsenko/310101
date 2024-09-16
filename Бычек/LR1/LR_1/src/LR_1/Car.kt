package LR_1

open class Car(
    private val name: String
){

    fun goByCar(){  //завестись
        println("Машина $name завелась")
    }

    open fun startToGo(){    //ехать
        println("Ехать на машине")
    }
}
