package com.atul.androidmasterclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countData: LiveData<Int>
    get() = count
    init {
        count.value = 0
    }
    fun getUpdatedCount(){
        count.value = count.value?.plus(1)
    }
}