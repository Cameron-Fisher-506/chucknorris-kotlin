package com.example.chucknorris.utils

import androidx.lifecycle.liveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.ChuckNorris
import com.example.chucknorris.model.models.ChuckNorrisWithJokes
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.room.*
import kotlinx.coroutines.Dispatchers

object DataAccessStrategyUtils {
    inline fun <reified T, reified A> getByQuery(baseDao: IBaseDao<A>, crossinline wsCall: suspend () -> Resource<T>) =
        liveData<Resource<T>>(Dispatchers.IO) {
            emit(Resource.loading())

            val response = wsCall.invoke()
            if (response.status == Status.SUCCESS && response.data != null) {
                emit(Resource.success(response.data))
                //cache
                if (response.data is ChuckNorrisWithJokes) {
                    baseDao.insert(response.data.jokes as List<A>)
                } else {
                    baseDao.insert(response.data as A)
                }
            } else {
                val result = baseDao.specialQuery(SimpleSQLiteQuery("SELECT * FROM ${A::class.java.simpleName} WHERE chuckNorrisId = 1"))
                if (result != null) {
                    val chuckNorrisWithJokes = ChuckNorrisWithJokes(ChuckNorris(), result as List<Joke>)
                    emit(Resource.success(chuckNorrisWithJokes as T))
                } else {
                    // No data to display
                    emit(Resource.error("No Connection."))
                }
            }
        }
}