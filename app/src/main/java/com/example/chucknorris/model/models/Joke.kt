package com.example.chucknorris.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Joke(@SerializedName("created_at")
           var createdAt: String = "",
           @SerializedName("icon_url")
           var iconUrl: String = "",
           @SerializedName("updated_at")
           var updatedAt: String = "",
           var url: String = "",
           var value: String = ""
): BaseModel(), Serializable
{
    @PrimaryKey(autoGenerate = true)
    @SerializedName("")
    override var id: Int = 0
}