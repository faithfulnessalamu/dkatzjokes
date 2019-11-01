package com.vague.android.dkatzjokes.data

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.data.source.DataSource

class DefaultRepository(val localDataSource: DataSource, val remoteDataSource: DataSource) : Repository {

    override fun getAllJokes(): LiveData<List<Joke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTenNewJokes(): LiveData<List<Joke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun saveJokes(jokes: List<Joke>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}