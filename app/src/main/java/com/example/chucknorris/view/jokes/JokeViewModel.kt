package com.example.chucknorris.view.jokes

import android.app.Application
import androidx.lifecycle.*
import com.example.chucknorris.model.FavouriteJoke
import com.example.chucknorris.model.Joke
import com.example.chucknorris.repository.JokeRepository
import com.example.chucknorris.model.Jokes
import com.example.chucknorris.repository.FavouriteJokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    val jokesBySearch by lazy { MutableLiveData<Jokes>() }

    private var jokeRepository = JokeRepository(application)

    fun getJokesBySearch(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = jokeRepository.getJokeBySearch(query)
            withContext(Dispatchers.Main) {
                jokesBySearch.value = if (response.isSuccessful) response.body() else null
            }
        }
    }
}