package com.vague.android.dkatzjokes.data

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.data.source.local.LocalDataSource
import com.vague.android.dkatzjokes.data.source.remote.RemoteDataSource

class DefaultRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getAllJokes(): LiveData<List<Joke>> = localDataSource.getAllJokes()

    override fun getTenNewJokes(): LiveData<List<Joke>> = remoteDataSource.getTenNewJokes()

    override suspend fun saveJokes(jokes: List<Joke>) {
        localDataSource.saveJokes(jokes)
    }
}