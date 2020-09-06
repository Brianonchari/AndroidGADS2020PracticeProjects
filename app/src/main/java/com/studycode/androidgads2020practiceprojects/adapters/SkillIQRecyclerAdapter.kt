package com.studycode.androidgads2020practiceprojects.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem
import kotlinx.android.synthetic.main.iq_item.view.*

class SkillIQRecyclerAdapter (private val skilliq:ArrayList<SkillIQItem>): RecyclerView.Adapter<SkillIQRecyclerAdapter.SkillIQViewHolder>(){
    class SkillIQViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(skillIQItem: SkillIQItem){
            itemView.learner_name.text = skillIQItem.name
            itemView.iq_details.text = skillIQItem.score.toString()+  "skill IQ Score" + skillIQItem.country
            Glide.with(itemView.badge.context).load(skillIQItem.badgeUrl).into(itemView.badge)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillIQViewHolder {
        return SkillIQViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.iq_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int  = skilliq.size
    override fun onBindViewHolder(holder: SkillIQViewHolder, position: Int) = holder.bind(skilliq[position])


    fun addData(list: List<SkillIQItem>) {
        skilliq.addAll(list)
    }


}