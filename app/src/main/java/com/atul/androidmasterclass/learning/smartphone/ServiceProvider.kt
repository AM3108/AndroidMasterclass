package com.atul.androidmasterclass.learning.smartphone

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {

    init {
        Log.i("MYTAG", "ServiceProvider Constructed")
    }

    fun getServiceProvider() {
        Log.i("MYTAG", "Service provider connected")
    }

}