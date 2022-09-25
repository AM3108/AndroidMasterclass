package com.atul.androidmasterclass.structuredconcurency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityUnstructuredBinding
import com.atul.androidmasterclass.unstructureconcurrency.UserDataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StructuredActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnstructuredBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_unstructured)
        binding.btnCoroutinesDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                binding.txtCount.text = UserDataManager2().getTotalUserCount().toString()
            }
        }
    }
}