package com.vague.android.dkatzjokes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        setupSwipeRefresh()

        return binding.root
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.viewModel?.setRefreshing(true)
            binding.viewModel?.getNewJokes()?.observe(viewLifecycleOwner,
                Observer {
                    homeTimber.d("In refresh Observer")
                    when (it) {
                        is ApiResult.Success -> {
                            homeTimber.d("Updating adapter")
                            if (it.data.isNotEmpty()) {
                                binding.viewModel?.setRefreshing(false)
                                (binding.recyclerviewJokesHome.adapter as HomeFragmentAdapter)
                                    .submitList(it.data)
                            }
                        }
                        is ApiResult.Failure -> {
                            binding.viewModel?.setRefreshing(false)
                            homeTimber.e(it.message)
                        }
                    }
                }
            )
        }
    }

    private fun setupRecyclerView() {
        homeTimber.d("setupRecyclerView Called")

        val adapter = HomeFragmentAdapter()
        binding.recyclerviewJokesHome.adapter = adapter
    }

    companion object {
        const val TAG = "HomeFragment_Timber"
    }
}