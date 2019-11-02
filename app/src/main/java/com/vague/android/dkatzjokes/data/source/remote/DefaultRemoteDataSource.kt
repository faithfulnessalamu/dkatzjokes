package com.vague.android.dkatzjokes.data.source.remote

import com.vague.android.dkatzjokes.data.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DefaultRemoteDataSource(private val dkatzApiService: DkatzApiService) : RemoteDataSource {

    override fun getTenNewJokes(): ApiResult {

        dkatzApiService.getTenNewJokes().apply {
            enqueue(object : Callback<List<Joke>> {
                override fun onFailure(call: Call<List<Joke>>, t: Throwable) {
                    ApiResult.Failure(t.message ?: "Cause not specified")
                }

                override fun onResponse(call: Call<List<Joke>>, response: Response<List<Joke>>) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            execute()
        }


    }

    companion object {
        const val TAG = "DefaultRemoteDS"
    }
}