package com.studycode.androidgads2020practiceprojects.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_submit.*

@AndroidEntryPoint
class SubmitActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SubmitActivity"
    }

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        submitButton.setOnClickListener {
            makeSubmission()
        }


    }

    private fun makeSubmission() {
        if (getValidInput()) {
            viewModel.makeSubmission(
                emailEditText.text.toString(),
                firstNameEditText.text.toString(),
                lastNameEditText.text.toString(),
                gitHubEditText.text.toString()
            )
        }
    }

    private fun getValidInput(): Boolean {
        if (emailEditText.text.isNullOrEmpty() || gitHubEditText.text.isNullOrEmpty() || lastNameEditText.text.isNullOrEmpty()) {
            LastNameTextInputLayout.error = "All Fields Are required"
            emailTextInputLayout.error = "Input a valid Email Address"
            return false
        }
        LastNameTextInputLayout.error = null
        emailTextInputLayout.error = null

        return true
    }
}
