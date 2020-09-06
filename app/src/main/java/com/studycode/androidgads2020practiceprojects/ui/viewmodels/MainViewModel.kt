package com.studycode.androidgads2020practiceprojects.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem
import com.studycode.androidgads2020practiceprojects.repository.MainRepository
import com.studycode.androidgads2020practiceprojects.utils.LoadingStatus
import com.studycode.androidgads2020practiceprojects.utils.NetworkHelper
import com.studycode.androidgads2020practiceprojects.utils.Resource
import com.studycode.androidgads2020practiceprojects.utils.Result
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _hours = MutableLiveData<Resource<List<HoursItem>>>()
    val hours: LiveData<Resource<List<HoursItem>>>
        get() = _hours

    private val _skilliq = MutableLiveData<Resource<List<SkillIQItem>>>()
    val skill: LiveData<Resource<List<SkillIQItem>>>
        get() = _skilliq

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean>
        get() = _success

    private val _loadingStatus = MutableLiveData<LoadingStatus>()
    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus

    init {
        fetchLearnersByHours()
        fetchLearnersBySkillIQ()

    }

    private fun fetchLearnersBySkillIQ() {
        viewModelScope.launch {
            _skilliq.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getLearnersBySkillIQ().let {
                    if (it.isSuccessful) {
                        _skilliq.postValue(Resource.success(it.body()))
                    } else _skilliq.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _skilliq.postValue(
                Resource.error(
                    "You do not have an active internet network",
                    null
                )
            )
        }

    }

    private fun fetchLearnersByHours() {
        viewModelScope.launch {
            _hours.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getLearnersByHours().let {
                    if (it.isSuccessful) {
                        _hours.postValue(Resource.success(it.body()))
                    } else _hours.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _hours.postValue(
                Resource.error(
                    "You do not have an active internet connection",
                    null
                )
            )
        }
    }


    fun makeSubmission(email: String, name: String, lastName: String, githubLink: String) {
        _loadingStatus.value = LoadingStatus.Loading("making your Submission ...")
        viewModelScope.launch {
            when (val result = mainRepository.makeSubmission(email, name, lastName, githubLink)) {
                is Result.Success -> {
                    _success.value = true
                    _loadingStatus.value = LoadingStatus.Success
                }
                is Result.Error -> {
                    _success.value = false
                    _loadingStatus.value = LoadingStatus.Error(result.message)
                }
            }
        }


    }
}