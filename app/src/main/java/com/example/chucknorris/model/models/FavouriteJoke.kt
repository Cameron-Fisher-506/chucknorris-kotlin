package com.example.chucknorris.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class FavouriteJoke(
    var createdAt: String = "",
    var iconUrl: String = "",
    var updatedAt: String = "",
    var url: String = "",
    var value: String = ""
) : BaseModel(), Serializable {
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
}