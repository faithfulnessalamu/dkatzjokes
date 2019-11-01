package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.ViewModel
import com.vague.android.dkatzjokes.data.Repository

class HomeFragmentViewModel(repository: Repository) : ViewModel() {

    val dataset = repository.getAllJokes()

    companion object {
        const val TAG = "HomeFragmentViewModel_Timber"
    }
}