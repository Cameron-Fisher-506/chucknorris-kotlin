package com.example.chucknorris.model

import com.google.gson.annotations.SerializedName

class Jokes(var total: Int = 0,
            @SerializedName("result")
            var jokes: List<Joke> = arrayListOf()
) {
}