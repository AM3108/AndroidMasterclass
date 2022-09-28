package com.atul.androidmasterclass.learning

class Car {
    private val engineInstance: Engine

    init {
        engineInstance = Engine()
        startCar()
    }

    private fun startCar(){
        engineInstance.startEngine()
    }
}
//Car class is a dependent and Engine class is a dependency as car class cannot work without engine class.

/*
This not a correct way to write dependcy injection.
as we have to write dependency outside of dependent object and inject them when needed through Interface.*/
