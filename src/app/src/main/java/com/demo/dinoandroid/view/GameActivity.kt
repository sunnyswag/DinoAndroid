package com.demo.dinoandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.demo.dinoandroid.R
import com.demo.dinoandroid.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
    }
}