package com.example.chucknorris.model.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

@Entity
data class ChuckNorrisWithJokes(
    @Embedded val chuckNorris: ChuckNorris,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )

    var total: Int = 0,
    @SerializedName("result")
    var jokes: List<Joke> = arrayListOf()
)