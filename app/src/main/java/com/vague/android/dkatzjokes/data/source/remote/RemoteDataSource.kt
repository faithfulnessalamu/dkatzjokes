package com.vague.android.dkatzjokes.data.source.remote

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

interface RemoteDataSource {

    fun getTenNewJokes(): LiveData<List<Joke>>
}