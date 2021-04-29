package com.example.chucknorris.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.model.service.ChuckNorrisService
import com.example.chucknorris.utils.DataAccessStrategyUtils
import com.example.chucknorris.utils.Resource

class JokeRepository(application: Application) {
    private val chuckNorrisService = ChuckNorrisService()
    private val jokeDao = ChuckNorrisDatabase.getDatabase(application).jokeDao()

    private val queryLiveData by lazy { MutableLiveData<String>()}
    private val updateRandomLiveData by lazy { MutableLiveData<Boolean>() }

    fun getJokesBySearch(query: String): LiveData<Resource<List<Joke>>> {
        queryLiveData.value = query
        return Transformations.switchMap(queryLiveData) {DataAccessStrategyUtils.synchronizedCache(jokeDao, it){ chuckNorrisService.getJokesBySearch(it) }}
    }

    fun getRandomJokes(update: Boolean): LiveData<Resource<List<Joke>>> {
        updateRandomLiveData.value = update
        return Transformations.switchMap(updateRandomLiveData) { DataAccessStrategyUtils.synchronizedCache(jokeDao, null){ chuckNorrisService.getJokesBySearch("Chuck Norris") } }
    }
}