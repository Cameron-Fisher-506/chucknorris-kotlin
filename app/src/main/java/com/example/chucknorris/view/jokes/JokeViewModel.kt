package com.example.chucknorris.view.jokes

import android.app.Application
import androidx.lifecycle.*
import com.example.chucknorris.model.repository.JokeRepository
import com.example.chucknorris.model.models.Jokes
import com.example.chucknorris.utils.Resource

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var jokesBySearch: LiveData<Resource<Jokes>>

    private var jokeRepository = JokeRepository(application)

    fun getJokesBySearch(query: String) {
        jokesBySearch = jokeRepository.getJokeBySearch(query)
    }
}