package com.example.chucknorris.view.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.chucknorris.model.Jokes
import com.example.chucknorris.model.service.ChuckNorrisService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    val jokesBySearch by lazy { MutableLiveData<Jokes>() }

    private val chuckNorrisService = ChuckNorrisService()

    fun getJokesBySearch(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = chuckNorrisService.getJokesBySearch(query)
            withContext(Dispatchers.Main){
                jokesBySearch.value = if(response.isSuccessful) response.body() else null
            }
        }
    }
}