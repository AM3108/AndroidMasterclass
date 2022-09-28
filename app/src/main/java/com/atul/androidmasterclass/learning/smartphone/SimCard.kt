package com.atul.androidmasterclass.learning.smartphone

import android.util.Log
import javax.inject.Inject

class SimCard @Inject constructor(private val serviceProvider: ServiceProvider) {
    //method Injecton part 1
    //private lateinit var serviceProvider: ServiceProvider

   //Field Injection
   // public lateinit var serviceProvider: ServiceProvider

    init {
       // setServiceProvider(ServiceProvider())
        Log.i("MYTAG", "Sim Card Constructed")
    }
    //Method Injection part 2
//    fun setServiceProvider(serviceProvider: ServiceProvider) {
//        this.serviceProvider = serviceProvider
//    }
    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}

