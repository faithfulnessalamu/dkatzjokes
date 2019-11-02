package com.vague.android.dkatzjokes.data.source.remote

import com.vague.android.dkatzjokes.data.model.Joke
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DkatzApiService {

    @GET("jokes/ten")
    fun getTenNewJokes(): Call<List<Joke>>

    companion object {
        const val BASE_URL = "https://official-joke-api.appspot.com"

        fun create(): DkatzApiService {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().also {
                    return it.create(DkatzApiService::class.java)
                }
        }
    }
}

