package com.vague.android.dkatzjokes.data.source.remote

import com.vague.android.dkatzjokes.data.model.Joke

sealed class ApiResult {
    class Success(val data: List<Joke>) : ApiResult()
    class Failure(val message: String) : ApiResult()
}