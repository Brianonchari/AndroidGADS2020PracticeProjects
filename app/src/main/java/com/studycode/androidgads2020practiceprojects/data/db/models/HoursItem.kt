package com.studycode.androidgads2020practiceprojects.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hours")
data class HoursItem(
    val badgeUrl: String,
    val country: String,
    val hours: Int,
    val name: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}