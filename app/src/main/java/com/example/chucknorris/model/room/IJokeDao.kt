package com.example.chucknorris.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chucknorris.model.models.Joke

@Dao
interface IJokeDao : IBaseDao<Joke> {

    @Query("SELECT * FROM joke WHERE value = :value")
    suspend fun findByValue(value: String): Joke?

    @Query("SELECT * FROM joke WHERE value LIKE ('%' || :value || '%')")
    suspend fun getAllByValue(value: String): List<Joke>?

    @Query("SELECT * FROM joke ORDER BY RANDOM() LIMIT 100")
    suspend fun getRandomJokes(): List<Joke>?
}