package com.example.chucknorris.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.entities.Jokes
import com.example.chucknorris.model.room.JokeDao
import kotlinx.coroutines.Dispatchers

object WSCallsUtils {
    fun <T> get(dao: JokeDao, wsCall: suspend () -> Resource<T>) =
        liveData<Resource<T>>(Dispatchers.IO) {
            emit(Resource.loading())
            val response = wsCall.invoke()
            if (response.status == Status.SUCCESS) {
                emit(Resource.success(response.data))
                //cache
                if (response.data is Jokes) {
                    dao.insert(response.data.jokes)
                }
            } else {
                //emit(Resource.error(response.message ?: "Service failed: Please contact developer!"))
                val data = dao.readAllJokes()
                data.value?.let { emit(Resource.success(it)) }
            }
        }
}