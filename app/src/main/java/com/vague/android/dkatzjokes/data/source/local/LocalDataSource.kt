package com.vague.android.dkatzjokes.data.source.local

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

interface LocalDataSource {

    fun getAllJokes(): LiveData<List<Joke>>

    suspend fun saveJokes(jokes: List<Joke>)
}