package com.demo.dinoandroid.view

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.demo.dinoandroid.R
import com.demo.dinoandroid.adapter.EnterViewPagerAdapter
import com.demo.dinoandroid.viewmodel.PagerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    private lateinit var pagerViewModel: PagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBar()

        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = EnterViewPagerAdapter(this)

        pagerViewModel = ViewModelProvider(this).get(PagerViewModel::class.java)
        pagerViewModel.goToGameFragment.observe(this) {
            if (it) {
                viewPager.currentItem = (viewPager.adapter as EnterViewPagerAdapter).itemCount - 1
            }
        }
    }

    private fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}