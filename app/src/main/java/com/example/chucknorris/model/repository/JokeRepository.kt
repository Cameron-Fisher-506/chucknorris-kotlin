package com.example.chucknorris.model.repository

import android.app.Application
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.model.room.IChuckNorrisDao
import com.example.chucknorris.model.service.ChuckNorrisService
import com.example.chucknorris.utils.WSCallsUtils

class JokeRepository(application: Application) {
    private val chuckNorrisService = ChuckNorrisService()
    private val jokeDao = ChuckNorrisDatabase.getDatabase(application).jokeDao()

    fun getJokeBySearch(query: String) = WSCallsUtils.getByQuery(jokeDao){ chuckNorrisService.getJokesBySearch(query) }
}