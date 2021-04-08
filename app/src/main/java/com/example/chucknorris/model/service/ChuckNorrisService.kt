package com.example.chucknorris.model.service

import com.example.chucknorris.model.Joke
import com.example.chucknorris.model.Jokes
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChuckNorrisService() {
    private lateinit var api: IChuckNorrisApi

    companion object
    {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        this.api = retrofit.create(IChuckNorrisApi::class.java)
    }

    suspend fun getCategories(): Response<List<String>>
    {
        return this.api.getCategories()
    }

    suspend fun getRandomJokeByCategory(category: String): Response<Joke>
    {
        return this.api.getRandomJokeByCategory(category)
    }

    suspend fun getJokesBySearch(query: String): Response<Jokes>
    {
        return this.api.getJokesBySearch(query)
    }
}