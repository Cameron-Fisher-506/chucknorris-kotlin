package com.example.chucknorris.view.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.repository.JokeRepository
import com.example.chucknorris.utils.Resource

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var jokesBySearchLiveData: LiveData<Resource<List<Joke>>>

    private val jokeRepository = JokeRepository(application)

    fun getJokesBySearch(query: String) {
        jokesBySearchLiveData = jokeRepository.getJokesBySearch(query)
    }
}