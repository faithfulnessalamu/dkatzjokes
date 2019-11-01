package com.vague.android.dkatzjokes.data.source.local

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

class DefaultLocalDataSource : LocalDataSource {

    override fun getAllJokes(): LiveData<List<Joke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun saveJokes(jokes: List<Joke>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}