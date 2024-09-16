package LR_1

import java.awt.Color.blue

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val car1=Car("Nissan")  //создание объекта Car

    val tractor1=Tractor("МТЗ", "Ковш, щётка") //создание объекта трактор

    val fuel=Fuel(0,50, 20) //создание объекта тпливного бака
    val wheel=Wheel(0,false)    //создание объекта колесо
    val corpus=Corpus(0,15) //создание объекта корпус
    val driver1=Driver(car1, wheel, corpus) //создание объекта водитель
    driver1.inflateTheWheel()   //надуть колесо (если сдуто, то надуть)
    driver1.openDoor()  //открыть дверь в введенном кол-ве(водитель->корпус->открыть дверь
    driver1.closeDoor() //закрыть двери(...->...->...)
    driver1.go()    //ехать на машине
    tractor1.goByCar()  //машина завелась
    val engine=Engine(0, wheel, fuel)
    val inner =engine.InnerClass()
    inner.callPrivatemethod()   //вызов метода завести двигатель
    //engine.startWork()  //двигатель завелся
    engine.work()   //двигатель работает
    engine.applyFuel()  //запросить топливо в каком-то кол-ве литров меньше 20 л
    engine.Rolate() //вращение колеса(двигатель->колесо->вращать колесо
    tractor1.startToGo()    //машина едет
    tractor1.clearAwaySnow()    //убирать снег инвентарем
    corpus.Details()    //масса корпуса
    wheel.Details() //масса колес
    engine.Details()    //масса двигателя
    fuel.Details()  //масса топливного бака
    println("Тактор едет, а вы знаете массы деталей. Я вас поздравляю)")
}