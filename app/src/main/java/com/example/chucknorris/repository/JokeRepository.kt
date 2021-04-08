package com.example.chucknorris.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.chucknorris.model.FavouriteJoke
import com.example.chucknorris.model.Joke
import com.example.chucknorris.model.Jokes
import com.example.chucknorris.model.room.JokeDatabase
import com.example.chucknorris.model.service.ChuckNorrisService
import kotlinx.coroutines.*
import retrofit2.Response

class JokeRepository(application: Application) {
    private val favouriteJokeDao = JokeDatabase.getDatabase(application).favouriteJokeDao()
    private val jokeDao = JokeDatabase.getDatabase(application).jokeDao()
    private val chuckNorrisService = ChuckNorrisService()

    fun saveFavouriteJoke(favouriteJoke: FavouriteJoke) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteJokeDao.insert(favouriteJoke)
        }
    }

    suspend fun findByValue(value: String): Joke? {
        return this.jokeDao.findByValue(value)
    }

    fun getAllFavouritedJokes(): LiveData<List<FavouriteJoke>> {
        return favouriteJokeDao.readAll()
    }

    suspend fun getJokeBySearch(query: String): Response<Jokes> {
        return this.chuckNorrisService.getJokesBySearch(query)
    }
}