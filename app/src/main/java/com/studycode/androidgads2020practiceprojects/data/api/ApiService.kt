package com.studycode.androidgads2020practiceprojects.data.api

import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem
import retrofit2.Response
import retrofit2.http.GET


interface ApiService{

    @GET("/api/hours")
    suspend fun getLearnersByHours():Response<List<HoursItem>>

    @GET("/api/skilliq")
    suspend fun getLearnersBySkillIQ():Response<List<SkillIQItem>>

}