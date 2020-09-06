package com.studycode.androidgads2020practiceprojects.data.api

import javax.inject.Inject

class FormHelperImpl @Inject constructor(
    private val formService: FormSubmitService
) :FormHelper{
}