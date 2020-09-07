package com.studycode.androidgads2020practiceprojects.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.android.synthetic.main.confirm_diallog.view.*

@AndroidEntryPoint
class SubmitActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    companion object {
        private const val TAG = "SubmitActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        submitButton.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.confirm_diallog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()
            mDialogView.button.setOnClickListener {
                makeSubmission()
                mAlertDialog.dismiss()
            }
            mDialogView.imageView.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }

        viewModel.success.observe(this, Observer {
            when(it){
                true ->{
                    showSuccessDialog()
                    viewModel.resetSuccessValue()
                }
                false ->{
                    showFailureDialog()
                    viewModel.resetSuccessValue()
                }
            }
        })

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

    private fun showSuccessDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.success_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val mAlertDialog = mBuilder.show()
    }

    private fun showFailureDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.failure_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        val mAlertDialog = mBuilder.show()
    }
}
