package com.studycode.androidgads2020practiceprojects.data.api

import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
):ApiHelper{
    override suspend fun getLearnersByHours(): Response<List<HoursItem>> = apiService.getLearnersByHours()

    override suspend fun getLearnersBySkillIQ(): Response<List<SkillIQItem>> = apiService.getLearnersBySkillIQ()

}