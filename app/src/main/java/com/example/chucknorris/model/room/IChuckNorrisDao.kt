package com.example.chucknorris.model.room

import androidx.room.Dao
import androidx.room.Query
import com.example.chucknorris.model.models.ChuckNorris

@Dao
interface IChuckNorrisDao: IBaseDao<ChuckNorris> {

}