package com.example.chucknorris.model.entities
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
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}