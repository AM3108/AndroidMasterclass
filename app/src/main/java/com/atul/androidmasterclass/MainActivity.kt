package com.atul.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnClickHere.setOnClickListener {
            binding.txtCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            downloadUserData()
        }
        binding.btnCoroutinesDownloadUserData.setOnClickListener {
            //CoroutineScope is a interface provide scope of the coroutine.
            //Dispatcher.IO is use to run the task in background thread.
            //Launch is a coroutine builder
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private fun downloadUserData() {
        for(i in 1..200000){
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}