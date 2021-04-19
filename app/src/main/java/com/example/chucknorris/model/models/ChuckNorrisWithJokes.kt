package com.example.chucknorris.model.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

data class ChuckNorrisWithJokes(
    @Embedded
    val chuckNorris: ChuckNorris,

    @Relation(parentColumn = "id", entityColumn = "chuckNorrisId")
    @SerializedName("result")
    var jokes: List<Joke>

    //var total: Int = 0
)