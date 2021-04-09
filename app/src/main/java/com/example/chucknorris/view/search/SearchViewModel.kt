package com.example.chucknorris.view.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chucknorris.model.entities.Jokes
import com.example.chucknorris.model.repository.JokeRepository
import com.example.chucknorris.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var jokesBySearch: LiveData<Resource<Jokes>>

    private val repository = JokeRepository(application)

    fun getJokesBySearch(query: String){
        jokesBySearch = repository.getJokeBySearch(query)
    }
}