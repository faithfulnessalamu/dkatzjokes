package com.vague.android.dkatzjokes.data.source.remote

interface RemoteDataSource {

    fun getTenNewJokes(): ApiResult
}