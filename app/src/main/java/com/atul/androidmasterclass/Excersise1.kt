package com.atul.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.databinding.ActivityExcersise1Binding

class Excersise1 : AppCompatActivity() {
    private lateinit var binding: ActivityExcersise1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_excersise1)
        binding.button.setOnClickListener {
            showProgressBar()
        }
    }

    private fun showProgressBar() {
        binding.apply {
            if(button.text == "START")
            {
                progressBar.visibility = View.VISIBLE
                button.text = "STOP"
            }else{
                progressBar.visibility = View.GONE
                button.text = "START"
            }
        }
    }
}