package com.vague.android.dkatzjokes.data.source.local

import com.vague.android.dkatzjokes.data.model.Joke

class DefaultLocalDataSource(private val jokesDao: JokesDao) : LocalDataSource {

    override fun getAllJokes() = jokesDao.getAllJokes()

    override suspend fun saveJokes(jokes: List<Joke>) {
        jokesDao.saveJokes(jokes)
    }
}