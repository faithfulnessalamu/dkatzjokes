package com.vague.android.dkatzjokes.data

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.data.source.remote.ApiResult

interface Repository {

    fun getAllJokes(): LiveData<List<Joke>>

    fun getTenNewJokes(): ApiResult

    suspend fun saveJokes(jokes: List<Joke>)
}