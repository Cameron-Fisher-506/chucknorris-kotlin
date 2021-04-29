package com.example.chucknorris.view.jokes

import android.app.Application
import androidx.lifecycle.*
import com.example.chucknorris.model.repository.JokeRepository
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.repository.ChuckNorrisRepository
import com.example.chucknorris.utils.Resource

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var randomJokesLiveData: LiveData<Resource<List<Joke>>>
    private var jokeRepository = JokeRepository(application)

    init {
        ChuckNorrisRepository(application)
    }

    fun getRandomJokes(update: Boolean) {
        this.randomJokesLiveData = this.jokeRepository.getRandomJokes(update)
    }
}