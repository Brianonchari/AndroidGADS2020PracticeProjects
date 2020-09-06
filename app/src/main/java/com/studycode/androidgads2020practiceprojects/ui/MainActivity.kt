package com.studycode.androidgads2020practiceprojects.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.adapters.ViewPagerAapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (viewPager != null) {
            val adapter =
                ViewPagerAapter(
                    supportFragmentManager
                )
            viewPager.adapter = adapter
        }

        submitButton.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }

    }

}