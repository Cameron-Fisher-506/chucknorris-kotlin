package com.example.chucknorris.model.repository

import android.app.Application
import com.example.chucknorris.model.models.ChuckNorris
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChuckNorrisRepository(application: Application) {
    private val chuckNorrisDao = ChuckNorrisDatabase.getDatabase(application).chuckNorrisDao()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            chuckNorrisDao.insert(ChuckNorris(1, "Chuck Norris"))
        }
    }
}