package com.example.chucknorris.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteJokeRepository(application: Application) {
    private val favouriteJokeDao = ChuckNorrisDatabase.getDatabase(application).favouriteJokeDao()
    private val findByValueLiveData by lazy { MutableLiveData<String>() }

    fun insert(favouriteJoke: FavouriteJoke) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteJokeDao.insert(favouriteJoke)
        }
    }

    fun delete(favouriteJoke: FavouriteJoke) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteJokeDao.delete(favouriteJoke)
        }
    }

    fun findByValue(value: String): LiveData<Resource<FavouriteJoke>> {
        findByValueLiveData.value = value
        return Transformations.switchMap(findByValueLiveData) {
            ChuckNorrisDatabase.getResponse { this.favouriteJokeDao.findByValue(it) }
        }
    }

    fun readAll(): LiveData<List<FavouriteJoke>> {
        return favouriteJokeDao.readAll()
    }
}