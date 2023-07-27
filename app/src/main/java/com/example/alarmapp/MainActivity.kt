package com.example.alarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
        }.attach()
    }

    private fun getTabIcon(position: Int): Int {
        return when(position){
            0 -> R.drawable.alarm
            1 -> R.drawable.timer__1_
            2 -> R.drawable.timer
            else -> {R.drawable.alarm}
        }
    }

    fun init(){
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.ViewPager)
    }
}