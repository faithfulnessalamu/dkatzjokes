package com.vague.android.dkatzjokes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vague.android.dkatzjokes.databinding.FragHomeBinding
import timber.log.Timber

class HomeFragment : Fragment() {

    private val homeTimber = Timber.tag(TAG)
    private lateinit var binding: FragHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        homeTimber.d("setupRecyclerView Called")

        val adapter = HomeFragmentAdapter()
        binding.recyclerviewJokesHome.adapter = adapter
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}