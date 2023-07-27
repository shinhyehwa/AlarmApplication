package com.example.alarmapp.Fragment.AlarmDisplay

import androidx.recyclerview.widget.DiffUtil
import com.example.alarmapp.Model.Alarm

class AlarmDiffUtilCallBack(private val newAlarm:List<Alarm>, private val oldAlarm: List<Alarm>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldAlarm.size
    }

    override fun getNewListSize(): Int {
        return newAlarm.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldAlarm[oldItemPosition].id == newAlarm[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldAlarm[oldItemPosition] == newAlarm[newItemPosition]
    }

}