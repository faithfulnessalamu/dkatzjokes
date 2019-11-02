package com.vague.android.dkatzjokes.data.source.remote

import androidx.lifecycle.LiveData

interface RemoteDataSource {

    fun getTenNewJokes(): LiveData<ApiResult>
}