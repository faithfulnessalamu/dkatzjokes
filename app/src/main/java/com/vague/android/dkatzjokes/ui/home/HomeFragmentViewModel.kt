package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vague.android.dkatzjokes.data.Repository

class HomeFragmentViewModel(repository: Repository) : ViewModel() {

    val dataset = repository.getAllJokes()

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing


    companion object {
        const val TAG = "HomeFragmentViewModel_Timber"
    }
}