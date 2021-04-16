package com.example.chucknorris.utils

import androidx.lifecycle.liveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.ChuckNorris
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import com.example.chucknorris.model.room.IBaseDao
import kotlinx.coroutines.Dispatchers

object WSCallsUtils {
    inline fun <reified T> get(baseDao: IBaseDao<T>, crossinline wsCall: suspend () -> Resource<T>) =
        liveData<Resource<T>>(Dispatchers.IO) {
            emit(Resource.loading())

            /*val response = wsCall.invoke()
            if (response.status == Status.SUCCESS && response.data != null) {
                emit(Resource.success(response.data))
                //cache
                if (response.data is ChuckNorrisWithJokes) {
                    baseDao.insert(response.data.jokes as T)
                } else {
                    baseDao.insert(response.data)
                }
            } else {
                val result = baseDao.specialQuery(SimpleSQLiteQuery("SELECT * FROM ${ChuckNorris::class.java.simpleName}"))
                if (result != null) {
                    val chuckNorrisWithJokes = ChuckNorrisWithJokes().apply {
                        jokes = result as List<Joke>
                    }
                    emit(Resource.success(jokes as T))
                } else {
                    // No data to display
                    emit(Resource.error("No Connection."))
                }
            }*/
        }
}