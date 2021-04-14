package com.example.chucknorris.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chucknorris.model.models.FavouriteJoke

@Dao
interface IFavouriteJokeDao: IBaseDao<FavouriteJoke> {

    @Query("SELECT * FROM favouritejoke WHERE value = :value")
    suspend fun findByValue(value: String): FavouriteJoke?

    @Query("SELECT * FROM favouritejoke")
    fun readAll(): LiveData<List<FavouriteJoke>>
}