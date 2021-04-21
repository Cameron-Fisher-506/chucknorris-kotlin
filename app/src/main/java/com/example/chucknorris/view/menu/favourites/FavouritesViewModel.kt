package com.example.chucknorris.view.menu.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.repository.FavouriteJokeRepository
import com.example.chucknorris.utils.Resource

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favouriteJokeRepository = FavouriteJokeRepository(application)
    val readAllFavouriteJokes = this.favouriteJokeRepository.readAll()
    lateinit var findByValueLiveData: LiveData<Resource<FavouriteJoke>>

    fun insert(favouriteJoke: FavouriteJoke) {
        favouriteJokeRepository.insert(favouriteJoke)
    }

    fun findByValue(value: String) {
        findByValueLiveData = this.favouriteJokeRepository.findByValue(value)
    }
}