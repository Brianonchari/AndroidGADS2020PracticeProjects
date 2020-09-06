package com.studycode.androidgads2020practiceprojects.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.studycode.androidgads2020practiceprojects.R
import com.studycode.androidgads2020practiceprojects.adapters.HoursRecyclerAdapter
import com.studycode.androidgads2020practiceprojects.data.db.models.HoursItem
import com.studycode.androidgads2020practiceprojects.ui.viewmodels.MainViewModel
import com.studycode.androidgads2020practiceprojects.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_learners.*

@AndroidEntryPoint
class HoursFragment : Fragment(R.layout.fragment_learners) {
    private val viewModel: MainViewModel by viewModels()
    lateinit var hoursAdapter: HoursRecyclerAdapter

    companion object {
        private const val TAG = "LearnersFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
        setupRecyclerview()

    }

    private fun subscribeToObservers() {
        viewModel.hours.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { users -> renderList(users) }

                }
                Status.LOADING -> {
//                    progress_bar.visibility = View.VISIBLE
//                    hours_recyclerview.visibility = View.GONE
                }
                Status.ERROR -> {
//                    progress_bar.visibility = View.GONE
//                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupRecyclerview() {

        hours_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        hoursAdapter = HoursRecyclerAdapter(arrayListOf())
        hours_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        hours_recyclerview.adapter = hoursAdapter
    }

    private fun renderList(hoursItem: List<HoursItem>) {
        hoursAdapter.addData(hoursItem)
        hoursAdapter.notifyDataSetChanged()
    }

}