package com.example.chucknorris.model.repository

import android.app.Application
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.model.service.ChuckNorrisService
import com.example.chucknorris.utils.DataAccessStrategyUtils

class JokeRepository(application: Application) {
    private val chuckNorrisService = ChuckNorrisService()
    private val jokeDao = ChuckNorrisDatabase.getDatabase(application).jokeDao()

    fun getJokesBySearch(query: String) = DataAccessStrategyUtils.getJokesByQuery(jokeDao, query){ chuckNorrisService.getJokesBySearch(query) }
}