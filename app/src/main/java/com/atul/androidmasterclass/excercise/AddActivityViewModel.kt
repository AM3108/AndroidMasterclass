package com.atul.androidmasterclass.excercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddActivityViewModel(startingTotal: Int) : ViewModel() {
     private var count = MutableLiveData<Int>()
     val countData: LiveData<Int>
     get() = count

    init {
        count.value = startingTotal
    }
    val inputText = MutableLiveData<String>()

    fun updatedCount(){
        val intInputText = inputText.value!!.toInt()
        count.value = count.value?.plus(intInputText)
    }
}