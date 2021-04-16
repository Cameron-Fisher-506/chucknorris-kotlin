package com.example.chucknorris.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ChuckNorris(
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0
): BaseModel(), Serializable