package com.vague.android.dkatzjokes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class Joke(
    @PrimaryKey val id: String,
    val type: String,
    val setup: String,
    val punchline: String
)