package com.example.chucknorris.model.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(indices = [Index(value = ["id"], unique = true)])
data class FavouriteJoke(
    @PrimaryKey
    var id: String = "",
    var createdAt: String = "",
    var iconUrl: String = "",
    var updatedAt: String = "",
    var url: String = "",
    var value: String = ""
) : BaseModel(), Serializable {
}