package com.studycode.androidgads2020practiceprojects.repository

import android.util.Log
import com.studycode.androidgads2020practiceprojects.data.api.ApiHelper
import com.studycode.androidgads2020practiceprojects.data.api.FormSubmitService
import com.studycode.androidgads2020practiceprojects.data.db.dao.HoursDao
import com.studycode.androidgads2020practiceprojects.utils.Result
import com.studycode.rickandmorty.ui.viewmodels.SkillIQDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    private val formSubmitService: FormSubmitService
) {
    suspend fun getLearnersByHours() = apiHelper.getLearnersByHours()
    suspend fun getLearnersBySkillIQ() = apiHelper.getLearnersBySkillIQ()

    suspend fun makeSubmission(
        emailAddress: String,
        name: String,
        lastName: String,
        linkToProject: String
    ):Result<Unit>{
        return try {
            Result.Success(withContext(Dispatchers.IO) {
                formSubmitService.submitFeedBack(emailAddress, name, lastName, linkToProject)
                    .await()
            })
        } catch (ex: Exception) {
            Log.e("mistake", ex.message!!)
            return Result.Error(ex.message!!)
        }

    }
}