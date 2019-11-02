package com.vague.android.dkatzjokes.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vague.android.dkatzjokes.data.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DefaultRemoteDataSource(private val dkatzApiService: DkatzApiService) : RemoteDataSource {

    override fun getTenNewJokes(): LiveData<ApiResult> {
        val result = MutableLiveData<ApiResult>(ApiResult.Success(emptyList()))

        dkatzApiService.getTenNewJokes().apply {
            enqueue(object : Callback<List<Joke>> {
                override fun onFailure(call: Call<List<Joke>>, t: Throwable) {
                    result.value = ApiResult.Failure(t.message ?: "Cause not specified")
                }

                override fun onResponse(call: Call<List<Joke>>, response: Response<List<Joke>>) {
                    if (response.isSuccessful) {
                        val list = response.body()
                        result.value = ApiResult.Success(list ?: emptyList())
                    } else {
                        result.value = ApiResult.Failure("Unsuccessful api call.")
                    }
                }
            })
        }

        return result
    }

    companion object {
        const val TAG = "DefaultRemoteDS"
    }
}