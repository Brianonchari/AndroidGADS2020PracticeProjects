package com.studycode.androidgads2020practiceprojects.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skillIq")
data class SkillIQItem(
    val badgeUrl: String,
    val country: String,
    val name: String,
    val score: Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}