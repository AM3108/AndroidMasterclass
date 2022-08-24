package com.atul.androidmasterclass.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityExcersiseOneBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ExcersiseOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExcersiseOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_excersise_one)
        binding.btnClickMain.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                Log.i("MyTag", "Thread Name is ${Thread.currentThread().name}")
            }
            binding.txtThreadName.text = "Main Thread"
        }
        binding.btnClickBackground.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("MyTag", "Thread Name is ${Thread.currentThread().name}")
            }
            binding.txtThreadName.text = "Background Thread"
        }
    }

}