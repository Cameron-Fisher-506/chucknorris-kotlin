package com.example.chucknorris.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chucknorris.model.entities.FavouriteJoke

@Dao
interface FavouriteJokeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favouriteJoke: FavouriteJoke)

    @Query("SELECT * FROM favouritejoke WHERE value = :value")
    suspend fun findByValue(value: String): FavouriteJoke?

    @Query("SELECT * FROM favouritejoke")
    fun readAll(): LiveData<List<FavouriteJoke>>
}