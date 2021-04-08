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
    private val chuckNorrisService = ChuckNorrisService()

    suspend fun getJokeBySearch(query: String): Response<Jokes> {
        return this.chuckNorrisService.getJokesBySearch(query)
    }
}