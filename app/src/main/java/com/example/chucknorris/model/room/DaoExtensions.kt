package com.example.chucknorris.model.room

import com.example.chucknorris.model.models.Joke

suspend fun <T> IBaseDao<T>.upsert(entities: List<T>, baseDao: IBaseDao<T>) {
    val insertResult: List<Long> = baseDao.insert(entities)
    val updateList: MutableList<T> = ArrayList()

    for (i in insertResult.indices) {
        if (insertResult[i] == -1L) {
            updateList.add(entities[i])
        }
    }

    if (updateList.isNotEmpty()) {
        baseDao.update(updateList)
    }
}

suspend fun <T> IBaseDao<T>.upsert(entity: T, baseDao: IBaseDao<T>) {
    val result = baseDao.insert(entity)
    if (result == -1L) {
        baseDao.update(entity)
    }
}