package com.vague.android.dkatzjokes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearSnapHelper
import com.vague.android.dkatzjokes.R
import com.vague.android.dkatzjokes.data.source.remote.ApiResult
import com.vague.android.dkatzjokes.databinding.FragHomeBinding
import com.vague.android.dkatzjokes.di.DependencyManager
import timber.log.Timber

class HomeFragment : Fragment() {

    private val homeTimber = Timber.tag(TAG)
    private lateinit var binding: FragHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragViewModel: HomeFragmentViewModel by viewModels {
            DependencyManager.provideHomeFragmentViewModelFactory(requireContext())
        }

        binding = FragHomeBinding.inflate(inflater, container, false)
            .apply {
                viewModel = fragViewModel
                lifecycleOwner = viewLifecycleOwner
            }


        setupRecyclerView()
        setupFab()

        binding.viewModel?.getSavedJokes()?.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            homeTimber.d(it.toString())
            (binding.recyclerviewJokesHome.adapter as HomeFragmentAdapter)
                .submitList(it.reversed())
            binding.recyclerviewJokesHome.adapter?.notifyItemInserted(0)
            binding.recyclerviewJokesHome.smoothScrollToPosition(0)
        })

        return binding.root
    }

    private fun setupFab() {
        binding.appFab.setOnClickListener {
            binding.viewModel?.setRefreshing(true)

            binding.viewModel?.getNewJokes()?.observe(viewLifecycleOwner,
                Observer {
                    homeTimber.d("In refresh Observer")
                    when (it) {
                        is ApiResult.Success -> {
                            if (it.data.isNotEmpty()) {
                                homeTimber.d("Updating adapter")
                                makeToast("  Done  ")
                                binding.viewModel?.setRefreshing(false)
                                binding.viewModel?.saveJokes(it.data)
                            }
                        }
                        is ApiResult.Failure -> {
                            binding.viewModel?.setRefreshing(false)
                            makeToast("  Network not available  ")
                            homeTimber.e(it.message)
                        }
                    }
                }
            )
        }


        binding.viewModel?.isRefreshing?.observe(viewLifecycleOwner, Observer {
            if (it) {
                makeToast("  Updating Jokes  ")
                // Start animation
                val rotation = AnimationUtils.loadAnimation(requireActivity(), R.anim.infinite_rotate).apply {
                    fillAfter = true
                }
                binding.appFab.startAnimation(rotation)
            } else {
                binding.appFab.clearAnimation()
            }
        })
    }

    private fun makeToast(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }


    private fun setupRecyclerView() {
        homeTimber.d("setupRecyclerView Called")

        val adapter = HomeFragmentAdapter()
        binding.recyclerviewJokesHome.adapter = adapter

        LinearSnapHelper().attachToRecyclerView(binding.recyclerviewJokesHome)
    }

    companion object {
        const val TAG = "HomeFragment_Timber"
    }
}