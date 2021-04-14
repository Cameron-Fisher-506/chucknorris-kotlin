package com.example.chucknorris.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.room.JokeDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteJokeRepository(application: Application) {
    private val favouriteJokeDao = JokeDatabase.getDatabase(application).favouriteJokeDao()

    fun insert(favouriteJoke: FavouriteJoke) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteJokeDao.insert(favouriteJoke)
        }
    }

    suspend fun findByValue(value: String): FavouriteJoke? {
        return this.favouriteJokeDao.findByValue(value)
    }

    fun readAll(): LiveData<List<FavouriteJoke>> {
        return favouriteJokeDao.readAll()
    }
}