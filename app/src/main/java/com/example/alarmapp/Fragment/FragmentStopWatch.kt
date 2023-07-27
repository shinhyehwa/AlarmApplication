package com.example.alarmapp.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentStopWatch : Fragment() {

    private lateinit var textStopWatch: TextView
    private lateinit var btnStop: FloatingActionButton
    private lateinit var btnStopTime: FloatingActionButton
    private lateinit var btnStart: FloatingActionButton
    private lateinit var listTimeStop: RecyclerView
    private var isPlaying: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_stop_watch, container, false)
        init(view)
        return view
    }

    private fun init(view: View){
        textStopWatch = view.findViewById(R.id.text_stop_watch)
        btnStart = view.findViewById(R.id.btnStart)
        btnStopTime = view.findViewById(R.id.btnStopTime)
        btnStop = view.findViewById(R.id.btnStop)

        btnStart.setOnClickListener {
            showFloatingActionButton()
            isPlaying = true
            Log.e("khongbiet", "khong chay duoc")
        }
        btnStop.setOnClickListener {
            showFloatingActionButton()
        }
        btnStopTime.setOnClickListener {
            textStopWatch.text = "00:00.16"
        }
    }

    private fun showFloatingActionButton(){
        if(!isPlaying){
            btnStart.visibility = View.GONE
            btnStopTime.visibility = View.VISIBLE
            btnStop.visibility = View.VISIBLE
        }else{
            btnStart.visibility = View.VISIBLE
            btnStopTime.visibility = View.GONE
            btnStop.visibility = View.GONE
        }
    }

}