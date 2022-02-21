package com.demo.dinoandroid.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.demo.dinoandroid.R
import com.demo.dinoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // https://developer.android.com/topic/libraries/data-binding/expressions
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.dinoIcon.visibility = View.VISIBLE
        binding.dinoIcon.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}