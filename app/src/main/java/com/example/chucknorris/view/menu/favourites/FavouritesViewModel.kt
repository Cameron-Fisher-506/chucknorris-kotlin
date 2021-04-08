package com.example.chucknorris.view.menu.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.chucknorris.model.FavouriteJoke
import com.example.chucknorris.repository.FavouriteJokeRepository

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favouriteJokeRepository = FavouriteJokeRepository(application)
    val readAllFavouriteJokes = this.favouriteJokeRepository.readAll()

    fun insert(favouriteJoke: FavouriteJoke) {
        favouriteJokeRepository.insert(favouriteJoke)
    }

    suspend fun findByValue(value: String): FavouriteJoke? {
        return this.favouriteJokeRepository.findByValue(value)
    }
}