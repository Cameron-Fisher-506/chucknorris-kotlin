package com.example.chucknorris.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chucknorris.model.Joke

@Dao
interface JokeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(joke: Joke)

    @Query("SELECT * FROM joke WHERE value = :value")
    suspend fun findByValue(value: String): Joke?

    @Query("SELECT * FROM joke")
    fun readAllJokes(): LiveData<List<Joke>>
}