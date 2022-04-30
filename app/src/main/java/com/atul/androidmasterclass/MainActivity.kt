package com.atul.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnName.setOnClickListener {
            displayGreetings()
        }
    }

    private fun displayGreetings(){
        //Using Apply Scope function we can reduce the repetition
        binding.apply {
            txtGreetings.text = "Hello! " + edtName.text
        }
        //Without Apply Scope function
       // binding.txtGreetings.text = "Hello!  " + binding.edtName.text
    }
}