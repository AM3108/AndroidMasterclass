package com.atul.androidmasterclass.switchthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivitySwitchThreadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SwitchThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwitchThreadBinding
    private var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_switch_thread)
        binding.btnClickHere.setOnClickListener {
            binding.txtCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private suspend fun downloadUserData() {
        for(i in 1..200000){
            // As in android we cannot call View component running in UI thread from background thread Like this.
            // Only the original thread that touches it's view hierarchy can touch it's view.
            //Therefore, we have to call views from UI or Main thread.
            //eg:- This below code will crash showing error call wrong thread exception.

           // binding.txtThreadName.text = "Downloading user $i in ${Thread.currentThread().name}"

          //The Coroutines provide easiest way to switch between thread, using withContext() function.
            //We can easily switch coroutine from one thread to another.
            // for eg:-
            withContext(Dispatchers.Main){
                binding.txtThreadName.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
            //This withContext() fn is a suspending fn.
            //we cannot call suspending fn from normal fn.
            //so we have to add suspend modifier to a fn declaration.

        }
    }
}
