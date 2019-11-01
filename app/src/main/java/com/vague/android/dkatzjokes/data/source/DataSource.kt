package com.vague.android.dkatzjokes.data.source

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

interface DataSource {

    fun getRandomJoke(): LiveData<Joke>

    fun getTenRandomJokes(): LiveData<List<Joke>>
}