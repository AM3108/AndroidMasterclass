package com.atul.androidmasterclass.learning.smartphone

import android.util.Log
import javax.inject.Inject

//Emaple of Inject
//class MemoryCard @Inject constructor()  {
//
//    init {
//        Log.i("MYTAG", "MemoryCard Constructed")
//    }
//
//    fun getSpaceAvailability() {
//        Log.i("MYTAG", "Memory space available.")
//    }
//
//

/*Assume this class we cannot use so how we will Inject these class
* To do these we have to create module class MemoryCardModule class */
class MemoryCard {

    init {
        Log.i("MYTAG", "MemoryCard Constructed")
    }

    fun getSpaceAvailability() {
        Log.i("MYTAG", "Memory space available.")
    }

}