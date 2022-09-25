package com.atul.androidmasterclass.unstructureconcurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityUnstructuredBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UnstructuredActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnstructuredBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_unstructured)
        binding.btnCoroutinesDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                binding.txtCount.text = UserDataManager().getTotalUserCount().toString()
            }
        }
    }
}