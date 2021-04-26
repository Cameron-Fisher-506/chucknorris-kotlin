package com.example.chucknorris.utils

import android.util.Log
import androidx.lifecycle.liveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.ChuckNorris
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.room.*
import kotlinx.coroutines.Dispatchers

object DataAccessStrategyUtils {
    inline fun <T> lazyCache(jokeDao: IJokeDao, query: String, crossinline wsCall: suspend () -> Resource<T>) =
        liveData<Resource<List<Joke>>>(Dispatchers.IO) {
            emit(Resource.loading())

            val result = jokeDao.getAllByValue(query)
            if (result != null && result.isNotEmpty()) {
                emit(Resource.success(result))
            } else {
                val response = wsCall.invoke()
                if (response.status == Status.SUCCESS && response.data != null) {
                    if (response.data is ChuckNorrisWithJokes) {
                        emit(Resource.success(response.data.jokes))
                        jokeDao.insert(response.data.jokes)
                    } else {
                        //jokeDao.insert(response.data as List<Joke>)
                    }
                } else {
                    emit(Resource.error("No data found."))
                }
            }
        }

    inline fun <T> synchronizedCache(jokeDao: IJokeDao, query: String, crossinline wsCall: suspend () -> Resource<T>) =
        liveData<Resource<List<Joke>>>(Dispatchers.IO) {
            emit(Resource.loading())

            val result = jokeDao.getAllByValue(query)
            if (result != null && result.isNotEmpty()) {
                var mustUpdate = false
                for (i in result.indices) {
                    if(DateTimeUtils.differenceInMinutes(result[i].timestamp, DateTimeUtils.getCurrentDateTime(DateTimeUtils.DASHED_PATTERN_YYYY_MM_DD_HH_MM_SS)) > DateTimeUtils.ONE_MINUTE) {
                        mustUpdate = true
                        break
                    }
                }

                if (mustUpdate) {
                    val response = wsCall.invoke()
                    if (response.status == Status.SUCCESS && response.data != null) {
                        if (response.data is ChuckNorrisWithJokes) {
                            emit(Resource.success(response.data.jokes))
                            jokeDao.update(response.data.jokes)
                        }
                    } else {
                        emit(Resource.error("No data found."))
                    }
                } else {
                    emit(Resource.success(result))
                }

            } else {
                val response = wsCall.invoke()
                if (response.status == Status.SUCCESS && response.data != null) {
                    if (response.data is ChuckNorrisWithJokes) {
                        emit(Resource.success(response.data.jokes))
                        jokeDao.insert(response.data.jokes)
                    }
                } else {
                    emit(Resource.error("No data found."))
                }
            }
        }
}