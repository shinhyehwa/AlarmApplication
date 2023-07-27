package com.example.alarmapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.alarmapp.Fragment.AlarmDisplay.FragmentAlarm
import com.example.alarmapp.Fragment.FragmentCountDown
import com.example.alarmapp.Fragment.FragmentStopWatch

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> FragmentAlarm()
            1 -> FragmentStopWatch()
            2 -> FragmentCountDown()
            else -> {
                FragmentAlarm()
            }
        }
    }
}