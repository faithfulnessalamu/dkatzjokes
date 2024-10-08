package com.vague.android.dkatzjokes.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vague.android.dkatzjokes.data.model.Joke

class FakeLocalDataSource : LocalDataSource {

    override fun getAllJokes(): LiveData<List<Joke>> {
        return MutableLiveData<List<Joke>>().apply {
            value = listOf(
                Joke("0", "Programming", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("1", "Programming", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("2", "Dark Humor", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("3", "Programming", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("5", "Pun", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("6", "Fashion", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("7", "Programming", "What did Lorem say to Ipsum?", "Yo, dolor sit amet"),
                Joke("8", "Programming", "What did Lorem say to Ipsum?", "Yo, dolor sit amet")
            )
        }
    }

    override suspend fun saveJokes(jokes: List<Joke>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}