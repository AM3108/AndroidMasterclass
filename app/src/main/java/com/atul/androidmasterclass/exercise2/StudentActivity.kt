package com.atul.androidmasterclass.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.atul.androidmasterclass.R
import com.atul.androidmasterclass.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student)
        //with layout initialisation
        binding.student = getStudent()

        //Without layout data
//        val student = getStudent()
//        binding.apply {
//            nameText.text = student.studentName
//            emailText.text = student.studentEmail
//        }
    }

    private fun getStudent(): Student {
        return Student(1, "Atul", "atulsmart1996@gmail.com")
    }
}