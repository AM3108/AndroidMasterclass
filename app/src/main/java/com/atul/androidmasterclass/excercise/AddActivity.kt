package com.atul.androidmasterclass.excercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var viewModel: AddActivityViewModel
    private lateinit var viewModelFactory: AddActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        viewModelFactory = AddActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory)[AddActivityViewModel::class.java]
        viewModel.countData.observe(this, {
            binding.txtValue.text = it.toString()
        })
        binding.btnAddValue.setOnClickListener {
            if(binding.edtEnterValue.text.isNotEmpty())
            {
                viewModel.updatedCount(binding.edtEnterValue.text.toString()).toString()
            }
        }
    }
}