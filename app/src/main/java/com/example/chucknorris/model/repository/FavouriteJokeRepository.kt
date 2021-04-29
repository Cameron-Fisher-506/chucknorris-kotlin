package com.example.chucknorris.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteJokeRepository(application: Application) {
    private val favouriteJokeDao = ChuckNorrisDatabase.getDatabase(application).favouriteJokeDao()

    fun insert(favouriteJoke: FavouriteJoke) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteJokeDao.insert(favouriteJoke)
        }
    }

    fun findByValue(value: String) = ChuckNorrisDatabase.getResponse { this.favouriteJokeDao.findByValue(value) }

    fun readAll(): LiveData<List<FavouriteJoke>> {
        return favouriteJokeDao.readAll()
    }
}