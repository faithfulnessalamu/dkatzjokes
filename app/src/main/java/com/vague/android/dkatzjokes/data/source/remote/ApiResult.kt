package com.vague.android.dkatzjokes.data.source.remote

import com.vague.android.dkatzjokes.data.model.Joke

sealed class ApiResult {
    class Success(data: List<Joke>) : ApiResult()
    class Failure(message: String) : ApiResult()
}