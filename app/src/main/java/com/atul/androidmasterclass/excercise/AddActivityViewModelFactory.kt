package com.atul.androidmasterclass.excercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class AddActivityViewModelFactory(private var startingTotal: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddActivityViewModel::class.java))
        {
            return AddActivityViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}