package com.example.chucknorris.model.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChuckNorrisService: BaseService() {
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

    suspend fun getCategories() = getResponse {  this.api.getCategories() }

    suspend fun getRandomJokeByCategory(category: String) = getResponse { this.api.getRandomJokeByCategory(category) }

    suspend fun getJokesBySearch(query: String) = getResponse { this.api.getJokesBySearch(query) }
}