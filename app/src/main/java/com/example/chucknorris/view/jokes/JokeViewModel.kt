package com.example.chucknorris.view.jokes

import android.app.Application
import androidx.lifecycle.*
import com.example.chucknorris.model.repository.JokeRepository
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import com.example.chucknorris.utils.Resource

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var chuckNorrisWithJokesBySearch: LiveData<Resource<ChuckNorrisWithJokes>>

    private var jokeRepository = JokeRepository(application)

    fun getJokesBySearch(query: String) {
        chuckNorrisWithJokesBySearch = jokeRepository.getJokeBySearch(query)
    }
}