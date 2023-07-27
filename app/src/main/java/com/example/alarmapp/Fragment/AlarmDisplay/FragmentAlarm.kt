package com.example.alarmapp.Fragment.AlarmDisplay

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmapp.Model.Alarm
import com.example.alarmapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentAlarm : Fragment() {
    private val itemAlarm: ArrayList<Alarm> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var alarmAdapterItem: AlarmAdapterItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm, container, false)
        recyclerView = view.findViewById(R.id.itemAlarm)
        floatingActionButton = view.findViewById(R.id.newAlarm)


        addData()
        recyclerView.layoutManager = LinearLayoutManager(context)
        alarmAdapterItem = AlarmAdapterItem(itemAlarm)
        recyclerView.adapter = alarmAdapterItem

        alarmAdapterItem.onItemClick = {

        }

        return view
    }

    private fun addData(){
        for(i in 1..10){
            val alarm = Alarm(i,7,1)
            itemAlarm.add(alarm)
        }
    }
}