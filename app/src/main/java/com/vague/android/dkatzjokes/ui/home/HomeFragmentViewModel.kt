package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vague.android.dkatzjokes.data.Repository
import com.vague.android.dkatzjokes.data.model.Joke

class HomeFragmentViewModel(repository: Repository) : ViewModel() {

    private val _dataset = repository.getAllJokes()
    val dataset: LiveData<List<Joke>>
        get() = _dataset


    companion object {
        const val TAG = "HomeFragmentViewModel_Timber"
    }
}