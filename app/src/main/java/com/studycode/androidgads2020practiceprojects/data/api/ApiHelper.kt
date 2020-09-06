package com.studycode.androidgads2020practiceprojects.data.api

import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem
import retrofit2.Response

interface ApiHelper {
    suspend fun getLearnersByHours() :Response<List<HoursItem>>
    suspend fun getLearnersBySkillIQ():Response<List<SkillIQItem>>
}