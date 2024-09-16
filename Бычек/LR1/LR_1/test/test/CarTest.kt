package test

import LR_1.Car
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CarTest {

    @Test
    fun goByCar() {
        val name="Porshe"
        val mycar = Car(name)
        mycar.goByCar()
    }
}