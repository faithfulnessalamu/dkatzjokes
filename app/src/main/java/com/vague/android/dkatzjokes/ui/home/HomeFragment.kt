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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}