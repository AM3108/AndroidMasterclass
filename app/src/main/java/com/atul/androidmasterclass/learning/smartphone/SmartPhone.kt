package com.atul.androidmasterclass.learning.smartphone

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(val battery: Battery, val memoryCard: MemoryCard, val simCard: SimCard) {

//    SmartPhone is a Dependent and Battery, MemoryCard, and Simcard are Dependency for this scenerio.
    init {
        battery.getPower()
        memoryCard.getSpaceAvailability()
        simCard.getConnection()
        Log.i("MYTAG", "SmartPhone Constructed")
    }

    fun makeACallWithRecording() {
        Log.i("MYTAG", "Calling...")
    }
}