package com.vague.android.dkatzjokes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vague.android.dkatzjokes.data.Repository
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.data.source.remote.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel(private val repository: Repository) : ViewModel() {

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    fun getSavedJokes() = repository.getAllJokes()

    fun getNewJokes(): LiveData<ApiResult> = repository.getTenNewJokes()

    fun setRefreshing(isRefreshing: Boolean) {
        _isRefreshing.value = isRefreshing
    }

    fun saveJokes(jokesList: List<Joke>) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.saveJokes(jokesList)
            }
        }
    }

    companion object {
        const val TAG = "HomeFragViewModel"
    }
}