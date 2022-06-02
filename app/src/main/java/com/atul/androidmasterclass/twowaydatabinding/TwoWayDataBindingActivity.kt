package com.atul.androidmasterclass.twowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityTwoWayDataBindingBinding

class TwoWayDataBindingActivity : AppCompatActivity() {
    private lateinit var bindingActivity: ActivityTwoWayDataBindingBinding
    private lateinit var viewModel: TwoWayDataBindingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = DataBindingUtil.setContentView(this, R.layout.activity_two_way_data_binding)
        viewModel = ViewModelProvider(this)[TwoWayDataBindingViewModel::class.java]
        bindingActivity.myViewModel = viewModel
        bindingActivity.lifecycleOwner = this
    }
}