package com.example.chucknorris.utils

import androidx.lifecycle.liveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.models.Jokes
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.model.room.IJokeDao
import kotlinx.coroutines.Dispatchers

object WSCallsUtils {
    inline fun <reified T> get(jokeDao: IJokeDao, crossinline wsCall: suspend () -> Resource<T>) =
        liveData<Resource<T>>(Dispatchers.IO) {
            emit(Resource.loading())

            val response = wsCall.invoke()
            if (response.status == Status.SUCCESS) {
                emit(Resource.success(response.data))
                //cache
                if (response.data is Jokes) {
                    jokeDao.insert(response.data.jokes)
                }
            } else {
                val result = jokeDao.specialQuery(SimpleSQLiteQuery("SELECT * FROM ${Joke::class.java.simpleName}"))
                if (result != null) {
                    val jokes = Jokes().apply {
                        jokes = result
                    }
                    emit(Resource.success(jokes as T))
                } else {
                    // No data to display
                    emit(Resource.error("No Connection."))
                }
            }
        }
}