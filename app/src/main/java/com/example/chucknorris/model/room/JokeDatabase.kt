package com.example.chucknorris.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.models.Joke

@Database(entities = [Joke::class, FavouriteJoke::class], version = 2, exportSchema = false)
abstract class JokeDatabase: RoomDatabase() {

    abstract fun jokeDao(): JokeDao
    abstract fun favouriteJokeDao(): FavouriteJokeDao

    companion object{
        @Volatile
        private var INSTANCE: JokeDatabase? = null

        fun getDatabase(context: Context): JokeDatabase
        {
            val tempInstance = INSTANCE
            tempInstance?.let { return tempInstance } ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokeDatabase::class.java,
                    "chucknorris"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}