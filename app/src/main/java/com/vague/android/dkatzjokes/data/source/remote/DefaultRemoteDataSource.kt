package com.vague.android.dkatzjokes.data.source.remote

import androidx.lifecycle.LiveData
import com.vague.android.dkatzjokes.data.model.Joke

class DefaultRemoteDataSource(val dkatzApiService: DkatzApiService) : RemoteDataSource {

    override fun getTenNewJokes(): LiveData<List<Joke>> {

    }

    companion object {
        const val TAG = "DefaultRemoteDS"
    }
}