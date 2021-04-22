package com.example.chucknorris.view.jokes

import android.app.Application
import androidx.lifecycle.*
import com.example.chucknorris.model.repository.JokeRepository
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.repository.ChuckNorrisRepository
import com.example.chucknorris.utils.Resource

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var jokesBySearchLiveData: LiveData<Resource<List<Joke>>>

    private var jokeRepository = JokeRepository(application)

    init {
        ChuckNorrisRepository(application)
    }

    fun getJokesBySearch(query: String) {
        jokesBySearchLiveData = jokeRepository.getJokesBySearch(query)
    }
}