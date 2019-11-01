package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vague.android.dkatzjokes.data.Repository

class HomeFragmentViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel(repository) as T
    }
}