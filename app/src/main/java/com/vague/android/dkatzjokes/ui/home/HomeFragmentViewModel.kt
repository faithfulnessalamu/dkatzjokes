package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vague.android.dkatzjokes.data.Repository
import com.vague.android.dkatzjokes.data.model.Joke
import timber.log.Timber

class HomeFragmentViewModel(private val repository: Repository) : ViewModel() {

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    val dataset: LiveData<List<Joke>>
        get() {
            val liveJokes = repository.getAllJokes()
            if (liveJokes.value == null) {
                return MutableLiveData(emptyList())
            }

            return liveJokes
        }

    fun refresh() {
        _isRefreshing.value = true
        Timber.tag(TAG).d("Refreshing")
        _isRefreshing.value = false
    }

    companion object {
        const val TAG = "HomeFragViewModel"
    }
}