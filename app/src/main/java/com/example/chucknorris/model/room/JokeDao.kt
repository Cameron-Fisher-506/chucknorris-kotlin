package com.example.chucknorris.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chucknorris.model.models.Joke

@Dao
interface JokeDao: BaseDao<Joke> {

    @Query("SELECT * FROM joke WHERE value = :value")
    suspend fun findByValue(value: String): Joke?

    @Query("SELECT * FROM joke")
    fun readAllJokes(): LiveData<List<Joke>>
}