package com.vague.android.dkatzjokes.data

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

interface Repository {

    fun getAllJokes(): LiveData<List<Joke>>

    fun getTenNewJokes(): LiveData<List<Joke>>

    suspend fun saveJokes(jokes: List<Joke>)
}