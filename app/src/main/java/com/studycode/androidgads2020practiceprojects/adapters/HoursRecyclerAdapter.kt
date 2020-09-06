package com.studycode.androidgads2020practiceprojects.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import kotlinx.android.synthetic.main.hours_item.view.*

class HoursRecyclerAdapter (private val hours:ArrayList<HoursItem>):RecyclerView.Adapter<HoursRecyclerAdapter.HoursViewHolder>(){
    class HoursViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(hoursItem: HoursItem){
            itemView.learner_name.text = hoursItem.name
            itemView.hours_details.text = hoursItem.hours.toString()  +"Learning hours, " + hoursItem.country
            Glide.with(itemView.badge.context).load(hoursItem.badgeUrl).into(itemView.badge)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
       return HoursViewHolder(
           LayoutInflater.from(parent.context)
               .inflate(
                   R.layout.hours_item,
                   parent,
                   false
               )
       )
    }

    override fun getItemCount(): Int  = hours.size

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int)  = holder.bind(hours[position])

    fun addData(list: List<HoursItem>) {
        hours.addAll(list)
    }
}
