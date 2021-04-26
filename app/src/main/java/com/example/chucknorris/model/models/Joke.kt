package com.example.chucknorris.model.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.chucknorris.utils.DateTimeUtils
import com.example.chucknorris.utils.GeneralUtils
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(indices = [Index(value = ["value"],unique = true)])
data class Joke(
    @PrimaryKey
    var id: String = "",
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("icon_url")
    var iconUrl: String = "",
    @SerializedName("updated_at")
    var updatedAt: String = "",
    var url: String = "",
    var value: String = "",
    var chuckNorrisId: Int = 1,
    var timestamp: String = DateTimeUtils.getCurrentDateTime(DateTimeUtils.DASHED_PATTERN_YYYY_MM_DD_HH_MM_SS)

) : BaseModel(), Serializable {
}