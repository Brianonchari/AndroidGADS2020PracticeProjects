package com.studycode.androidgads2020practiceprojects.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.studycode.androidgads2020practiceprojects.ui.fragments.HoursFragment
import com.studycode.androidgads2020practiceprojects.ui.fragments.SkillIQFragment

class ViewPagerAapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val COUNT = 2
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HoursFragment()
            1 -> fragment = SkillIQFragment()
        }

        return fragment!!

    }

    override fun getCount(): Int {
        return COUNT
    }

    val pageTitles = arrayOf("LEARNING LEADERS", "SKILL IQ LEADERS")
    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitles[position]


    }
}
