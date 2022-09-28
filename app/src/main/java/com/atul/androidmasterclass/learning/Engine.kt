package com.atul.androidmasterclass.learning

class Engine {

    private val pistonInstance: Piston

    init {
        pistonInstance = Piston()
    }

    fun startEngine() {
        TODO("Not yet implemented")
    }
}

/*1) In these case Engine class become dependent and Piston class become dependency.
2) And Piston class become indirect dependency of Car class. */