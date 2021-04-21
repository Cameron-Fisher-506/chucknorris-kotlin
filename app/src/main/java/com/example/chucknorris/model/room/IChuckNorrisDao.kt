package com.example.chucknorris.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chucknorris.model.models.ChuckNorris
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import com.example.chucknorris.model.models.Joke

@Dao
interface IChuckNorrisDao : IBaseDao<ChuckNorris> {
    @Query("SELECT * FROM chucknorris")
    suspend fun getAllChuckNorrisWithJokes(): List<ChuckNorrisWithJokes>?
}