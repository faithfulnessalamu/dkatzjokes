package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.ViewModel
import com.vague.android.dkatzjokes.data.Repository

class HomeFragmentViewModel(val repository: Repository) : ViewModel() {

    companion object {
        const val TAG = "HomeFragmentViewmodel_Timber"
    }
}