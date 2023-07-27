package com.example.alarmapp.Fragment.AlarmDisplay

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmapp.Model.Alarm
import com.example.alarmapp.R

class AlarmAdapterItem(private val itemAlarm: ArrayList<Alarm>): RecyclerView.Adapter<AlarmAdapterItem.ViewHolder>() {
    lateinit var onItemClick: ((Alarm) -> Unit)
    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val txtTime : TextView = view.findViewById(R.id.txt_Time)
        val txtRepeat: TextView = view.findViewById(R.id.txt_repeat)
        val switchAlarm: Switch = view.findViewById(R.id.switchAlarm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View =LayoutInflater.from(parent.context).inflate(R.layout.custom_item_alarm,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = itemAlarm.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = itemAlarm[position]
        val formatTime: String = "${data.time}:00"
        holder.txtTime.text = formatTime
        holder.txtRepeat.text = (if(data.repeat == 1 ){
            "mot lan"
        } else {
            "nhieu hon mot lan"
        }).toString()
        if(holder.switchAlarm.isChecked){
            holder.itemView.alpha = 1f
        }else{
            holder.itemView.alpha = 0.5f
        }
        holder.switchAlarm.setOnCheckedChangeListener(object:CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(isChecked){
                    Log.e("ischeck", "$isChecked")
                    holder.itemView.alpha = 1f
                }else{
                    Log.e("ischeck", "$isChecked")
                    holder.itemView.alpha = 0.5f
                }
            }

        })
        holder.itemView.setOnClickListener {
            Log.e("click item Alarm", "${data.id}")
            onItemClick.invoke(data)
        }
    }

    fun updateData(newItem : ArrayList<Alarm>){
        val result = DiffUtil.calculateDiff(AlarmDiffUtilCallBack(newItem,itemAlarm))
        itemAlarm.clear()
        itemAlarm.addAll(newItem)
        result.dispatchUpdatesTo(this)
    }
    private fun checkAlarm(isCheck: Boolean){

    }
}