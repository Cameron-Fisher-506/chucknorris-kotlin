package com.example.chucknorris.model.repository

import android.app.Application
import androidx.lifecycle.liveData
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.entities.Joke
import com.example.chucknorris.model.entities.Jokes
import com.example.chucknorris.model.room.JokeDao
import com.example.chucknorris.model.room.JokeDatabase
import com.example.chucknorris.model.service.ChuckNorrisService
import com.example.chucknorris.utils.Resource
import com.example.chucknorris.utils.WSCallsUtils
import kotlinx.coroutines.*

class JokeRepository(application: Application) {
    private val chuckNorrisService = ChuckNorrisService()
    private val jokeDao = JokeDatabase.getDatabase(application).jokeDao()

    /*fun getJokeBySearch(query: String) = liveData<Resource<Jokes>>(Dispatchers.IO) {
        emit(Resource.loading())
        val response = chuckNorrisService.getJokesBySearch(query)
        if (response.status == Status.SUCCESS) {
            response.data?.jokes?.get(0)?.let { jokeDao.insert(it) }
            emit(Resource.success(response.data))
        } else {
            emit(Resource.error(response.message ?: "Service failed: Please contact developer!"))
        }
    }*/

    fun getJokeBySearch(query: String) = WSCallsUtils.get(jokeDao){ chuckNorrisService.getJokesBySearch(query) }
}