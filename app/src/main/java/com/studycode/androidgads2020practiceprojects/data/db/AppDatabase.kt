package com.studycode.androidgads2020practiceprojects.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.studycode.androidgads2020practiceprojects.data.db.dao.HoursDao
import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem

@Database(
    entities = [HoursItem::class, SkillIQItem::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getHoursDao(): HoursDao

}