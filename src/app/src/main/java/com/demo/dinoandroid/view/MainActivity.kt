package com.demo.dinoandroid.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.dinoandroid.R
import com.demo.dinoandroid.adapter.ReferencesListAdapter
import com.demo.dinoandroid.domain.ReferenceData
import com.demo.dinoandroid.viewmodel.ReferencesViewModel
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ReferencesViewModel

    private lateinit var referencesList: RecyclerView
    private lateinit var dinoIcon: GifImageView
    private lateinit var references: TextView

    private val dataSet = listOf(ReferenceData("123", "12432", "https://github.com/sunnyswag/DinoAndroid"),
        ReferenceData("1234", "124322","https://github.com/sunnyswag/DinoAndroid"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        initViewModel()
        initAdapter()
    }

    private fun initAdapter() {
        referencesList.layoutManager = LinearLayoutManager(this)
        referencesList.adapter = ReferencesListAdapter(dataSet, viewModel)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ReferencesViewModel::class.java)
        viewModel.referenceSelected.observe(this) {
            referencesList.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun initUI() {
        dinoIcon = findViewById(R.id.dino_icon)
        references = findViewById(R.id.references)
        referencesList = findViewById(R.id.referencesList)

        dinoIcon.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        references.setOnClickListener {
            referencesList.visibility = View.VISIBLE
        }
    }


}