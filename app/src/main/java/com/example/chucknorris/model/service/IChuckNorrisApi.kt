package com.example.chucknorris.model.service

import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IChuckNorrisApi
{
    @GET("categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("random")
    suspend fun getRandomJokeByCategory(@Query("category") category: String): Response<Joke>

    @GET("search")
    suspend fun getJokesBySearch(@Query("query") query: String): Response<ChuckNorrisWithJokes>
}