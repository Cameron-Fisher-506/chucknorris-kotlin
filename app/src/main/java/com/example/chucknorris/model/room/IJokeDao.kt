package com.example.chucknorris.model.room

import androidx.room.Dao
import androidx.room.Query
import com.example.chucknorris.model.models.Joke

@Dao
interface IJokeDao : IBaseDao<Joke> {

    @Query("SELECT * FROM joke WHERE value = :value")
    suspend fun findByValue(value: String): Joke?


}