package com.example.chucknorris.model.room

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entities: List<T>)

    @Update
    suspend fun update(entity: T)

    @Update
    suspend fun update(entities: List<T>)

    @Delete
    suspend fun delete(entity: T)

    @Delete
    suspend fun delete(entities: List<T>)
}