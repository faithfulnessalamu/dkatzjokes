package com.vague.android.dkatzjokes.data

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.data.source.local.LocalDataSource
import com.vague.android.dkatzjokes.data.source.remote.ApiResult
import com.vague.android.dkatzjokes.data.source.remote.RemoteDataSource

class DefaultRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getAllJokes() = localDataSource.getAllJokes()

    override fun getTenNewJokes(): LiveData<ApiResult> = remoteDataSource.getTenNewJokes()

    override suspend fun saveJokes(jokes: List<Joke>) {
        localDataSource.saveJokes(jokes)
    }
}