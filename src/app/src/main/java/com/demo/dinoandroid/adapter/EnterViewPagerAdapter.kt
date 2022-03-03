package com.demo.dinoandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.dinoandroid.view.EnterFragment
import com.demo.dinoandroid.view.GameFragment

class EnterViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    private val pagerCreator = mapOf(
        ENTER_PAGER to { EnterFragment() },
        GAME_PAGER to { GameFragment() }
    )

    override fun getItemCount(): Int {
        return pagerCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return pagerCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    companion object PagerIndex{
        const val ENTER_PAGER = 0
        const val GAME_PAGER = 1
    }
}