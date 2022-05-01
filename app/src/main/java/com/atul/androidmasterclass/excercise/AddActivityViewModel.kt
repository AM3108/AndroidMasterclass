package com.atul.androidmasterclass.excercise

import androidx.lifecycle.ViewModel

class AddActivityViewModel(startingTotal: Int) : ViewModel() {
    private var count: Int = 0

    init {
        count = startingTotal
    }

    fun getCurrentCount(): Int{
        return count
    }

    fun updatedCount(value: String): Int{
        count += value.toInt()
        return count
    }
}