package com.atul.androidmasterclass.twowaydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayDataBindingViewModel : ViewModel() {
    var userName = MutableLiveData<String>()
    init {
        userName.value = "Atul"
    }
}