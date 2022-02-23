package com.demo.dinoandroid.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.dinoandroid.R
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // https://developer.android.com/topic/libraries/data-binding/expressions
        setContentView(R.layout.activity_main)
        val dinoIcon = findViewById<GifImageView>(R.id.dino_icon)
        val references = findViewById<TextView>(R.id.references)
        val referencesList = findViewById<RecyclerView>(R.id.referencesList)

        dinoIcon.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        references.setOnClickListener {
            referencesList.visibility = View.VISIBLE
        }
    }


}