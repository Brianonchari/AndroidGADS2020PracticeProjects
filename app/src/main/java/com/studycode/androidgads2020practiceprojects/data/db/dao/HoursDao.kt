package com.studycode.androidgads2020practiceprojects.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem

@Dao
interface HoursDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(hoursItem: HoursItem):Long

    @Query("SELECT * FROM hours")
    fun getLearnersByHours(): LiveData<List<HoursItem>>

    @Delete
    suspend fun deleteArticle(hoursItem: HoursItem)
}