package com.example.chucknorris

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.room.ChuckNorrisDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.chucknorris", appContext.packageName)
    }

    @Test
    fun update() {
        val joke1 = Joke().apply {
            id = "Tg3Q-ujvSpOXmrrkZUhVHA"
            createdAt = "2020-01-05 13:42:19.576875"
            iconUrl = "https://assets.chucknorris.host/img/avatar/chuck-norris.png"
            updatedAt = "2020-01-05 13:42:19.576875"
            url = "https://api.chucknorris.io/jokes/Tg3Q-ujvSpOXmrrkZUhVHA"
            value = "Maa"
            chuckNorrisId = 1
            timestamp = "2022-04-26 12:20:23"
        }

        val joke2 = Joke().apply {
            id = "5D6ilY48Q8yoE4_ch_U8Dw"
            createdAt = "2020-01-05 13:42:19.576875"
            iconUrl = "https://assets.chucknorris.host/img/avatar/chuck-norris.png"
            updatedAt = "2020-01-05 13:42:19.576875"
            url = "https://api.chucknorris.io/jokes/Tg3Q-ujvSpOXmrrkZUhVHA"
            value = "Paa"
            chuckNorrisId = 1
            timestamp = "2022-04-26 12:20:23"
        }

        val jokes = arrayListOf(joke1, joke2)

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val jokeDao = ChuckNorrisDatabase.getDatabase(context).jokeDao()
        CoroutineScope(Dispatchers.IO).launch {
            jokeDao.update(jokes)
        }

    }
}