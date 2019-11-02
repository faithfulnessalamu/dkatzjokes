package com.vague.android.dkatzjokes.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vague.android.dkatzjokes.data.model.Joke

@Dao
interface JokesDao {

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): LiveData<List<Joke>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveJokes(jokes: List<Joke>)
}