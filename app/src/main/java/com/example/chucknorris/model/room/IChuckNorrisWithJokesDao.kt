package com.example.chucknorris.model.room

import androidx.room.Dao
import com.example.chucknorris.model.models.ChuckNorrisWithJokes

@Dao
interface IChuckNorrisWithJokesDao: IBaseDao<ChuckNorrisWithJokes> {
}