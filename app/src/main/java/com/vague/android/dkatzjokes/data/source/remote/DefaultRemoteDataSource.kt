package com.vague.android.dkatzjokes.data.source.remote

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

class DefaultRemoteDataSource : RemoteDataSource {

    override fun getTenNewJokes(): LiveData<List<Joke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}