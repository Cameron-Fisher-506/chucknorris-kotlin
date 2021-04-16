package com.example.chucknorris.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.models.Joke

@Database(entities = [Joke::class, FavouriteJoke::class], version = 2, exportSchema = false)
abstract class ChuckNorrisDatabase : RoomDatabase() {

    abstract fun jokeDao(): IJokeDao
    abstract fun favouriteJokeDao(): IFavouriteJokeDao
    abstract fun chuckNorrisWithJokesDao(): IChuckNorrisWithJokesDao
    abstract fun chuckNorrisDao(): IChuckNorrisDao

    companion object {
        @Volatile
        private var INSTANCE: ChuckNorrisDatabase? = null

        fun getDatabase(context: Context): ChuckNorrisDatabase {
            val tempInstance = INSTANCE
            tempInstance?.let { return tempInstance } ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChuckNorrisDatabase::class.java,
                    "chucknorris"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}