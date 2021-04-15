package com.example.chucknorris.utils

import androidx.lifecycle.liveData
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.Jokes
import com.example.chucknorris.model.room.IJokeDao
import kotlinx.coroutines.Dispatchers

object WSCallsUtils {
    fun <T> get(daoJokeDao: IJokeDao, wsCall: suspend () -> Resource<T>) =
        liveData<Resource<T>>(Dispatchers.IO) {
            emit(Resource.loading())
            val response = wsCall.invoke()
            if (response.status == Status.SUCCESS) {
                emit(Resource.success(response.data))
                //cache
                if (response.data is Jokes) {
                    daoJokeDao.insert(response.data.jokes)
                }
            } else {
                emit(Resource.error(response.message ?: "Service failed: Please contact developer!"))
            }
        }
}