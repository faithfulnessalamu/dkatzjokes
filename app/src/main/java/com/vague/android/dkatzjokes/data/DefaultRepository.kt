package com.vague.android.dkatzjokes.data

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.data.source.local.LocalDataSource
import com.vague.android.dkatzjokes.data.source.remote.RemoteDataSource

class DefaultRepository(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) : Repository {

    override fun getAllJokes(): LiveData<List<Joke>> = localDataSource.getAllJokes()

    override fun getTenNewJokes(): LiveData<List<Joke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun saveJokes(jokes: List<Joke>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}