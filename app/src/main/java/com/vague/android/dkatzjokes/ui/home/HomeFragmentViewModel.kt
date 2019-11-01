package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vague.android.dkatzjokes.data.Repository
import com.vague.android.dkatzjokes.data.model.Joke

class HomeFragmentViewModel(val repository: Repository) : ViewModel() {

    private val _dataset = MutableLiveData<List<Joke>>(emptyList())
    val dataset: LiveData<List<Joke>>
        get() = _dataset


    companion object {
        const val TAG = "HomeFragmentViewmodel_Timber"
    }
}