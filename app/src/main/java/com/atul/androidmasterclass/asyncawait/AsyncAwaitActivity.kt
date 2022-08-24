package com.atul.androidmasterclass.asyncawait

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityAsyncAwaitBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class AsyncAwaitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAsyncAwaitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_async_await)
        //Sequential Decomposition example
        binding.btnDownloadUserData.setOnClickListener {
           CoroutineScope(IO).launch {
               Log.i("MyTag","Calculation Started......")
               val stock1 = stock1()
               val stock2 = stock2()
               val total = stock1 + stock2
               Log.i("MyTag","Total download count is $total")
               // This entire process will take 15 sec
           }
        }
        //Parallel Decomposition achieve by async and await eg;-
        binding.btnDownloadUserDataParallel.setOnClickListener {
            CoroutineScope(IO).launch { //launch builder returns job.
                Log.i("MyTag","Calculation Started for parallel......")
                val stock1 = async {stock1()} // async builder returns instance of Deferred.
                val stock2 = async {stock2()} // we can use deferred value by invoking await function.
                // To get the return value we need to invoke await fn of each async builder.
                val total = stock1.await() + stock2.await()
                Log.i("MyTag","Total download count is $total")
                // This entire process will take 9 sec
            }
        }
        // we can also provide dispatcher for parallel task. eg:-
        binding.btnDownloadUserDataMain.setOnClickListener {
            CoroutineScope(Main).launch {
                Log.i("MyTag","Calculation Started for main......") // Main Thread
                val stock1 = async(IO) {stock1()} //Only this parallel event will work in the background
                val stock2 = async(IO) {stock2()} // Background
                val total = stock1.await() + stock2.await() //Main Thread
                binding.txtTotalCount.text = "Total download count is $total" //Main Thread
                Log.i("MyTag","Total download count is $total") //Main Thread
            }
        }
    }

    private suspend fun stock1(): Int {
        delay(9000)
        Log.i("MyTag","Stock1 returned")
        return 10
    }
    private suspend fun stock2(): Int {
        delay(6000)
        Log.i("MyTag","Stock2 returned")
        return 7
    }
}