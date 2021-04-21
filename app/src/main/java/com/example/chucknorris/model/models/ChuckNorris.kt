package com.example.chucknorris.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ChuckNorris(
    @PrimaryKey(autoGenerate = false)
    override var id: Int = 1,
    val name: String = ""
) : BaseModel(), Serializable