package com.example.chucknorris.model.repository

import android.app.Application
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.model.service.ChuckNorrisService
import com.example.chucknorris.utils.WSCallsUtils

class JokeRepository(application: Application) {
    private val chuckNorrisService = ChuckNorrisService()
    private val chuckNorrisWithJokesDao = ChuckNorrisDatabase.getDatabase(application).chuckNorrisWithJokesDao()

    fun getJokeBySearch(query: String) = WSCallsUtils.get(chuckNorrisWithJokesDao){ chuckNorrisService.getJokesBySearch(query) }
}