package com.studycode.androidgads2020practiceprojects.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.adapters.SkillIQRecyclerAdapter
import com.studycode.androidgads2020practiceprojects.data.db.models.SkillIQItem
import com.studycode.androidgads2020practiceprojects.ui.viewmodels.MainViewModel
import com.studycode.androidgads2020practiceprojects.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_skilliq.*

@AndroidEntryPoint
class SkillIQFragment :Fragment(R.layout.fragment_skilliq){
    companion object{
        private const val TAG = "SkillIQFragment"
    }
    private lateinit var skillIQRecyclerAdapter: SkillIQRecyclerAdapter
    private val viewModel:MainViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
        subscribeToObservers()

    }

    private fun setupRecyclerview(){
        skill_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        skillIQRecyclerAdapter = SkillIQRecyclerAdapter(arrayListOf())
        skill_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        skill_recyclerview.adapter = skillIQRecyclerAdapter
    }

    private fun subscribeToObservers(){
        viewModel.skill.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS ->{
                    it.data?.let { users -> renderList(users) }

                }
                Status.LOADING ->{

                }
                Status.ERROR ->{

                }
            }
        })
    }

    private fun renderList(skillIQItem:  List<SkillIQItem>) {
        skillIQRecyclerAdapter.addData(skillIQItem)
        skillIQRecyclerAdapter.notifyDataSetChanged()
    }

}