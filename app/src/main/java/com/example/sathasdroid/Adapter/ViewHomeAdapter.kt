package com.example.sathasdroid.Adapter

import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sathasdroid.Entity.Holiday
import com.example.sathasdroid.R

/*
* The Adapter Class Is Used For Parameterizing @MainActivity
* */
class ViewHomeAdapter(
    private val holidayCardClicked:(Holiday)->Unit
): RecyclerView.Adapter<ViewHomeViewHolder>() {

    private val holidayList = ArrayList<Holiday>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.holiday_item,parent,false)
        return ViewHomeViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return holidayList.size
    }

    override fun onBindViewHolder(holder: ViewHomeViewHolder, position: Int) {
        holder.bind(holidayList[position], holidayCardClicked)
    }

    fun setList(holiday: List<Holiday>){
        holidayList.clear()
        holidayList.addAll(holiday)
        notifyDataSetChanged()
    }
}
class ViewHomeViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(holiday: Holiday, holidayCardClicked:(Holiday)->Unit){
        val tvDate = view.findViewById<TextView>(R.id.tvDate)
        val tvHolidayName = view.findViewById<TextView>(R.id.tvHolidayName)
        val tvType = view.findViewById<TextView>(R.id.tvType)

        tvDate.text = holiday.date
        tvHolidayName.text = holiday.name
        tvType.text = holiday.type

        val holidayCardClicked = view.findViewById<androidx.cardview.widget.CardView>(R.id.cvMainCard)
        holidayCardClicked.setOnClickListener{
            holidayCardClicked(holiday)
        }
    }
}