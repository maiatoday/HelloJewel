package com.github.maiatoday.hellojewel.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json

class DogImageRepository {
    private val BASE_URL = "https://dog.ceo/api/breeds/image/random"
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            level = LogLevel.INFO
        }
    }

 suspend fun getDogNameUrl(): String {
        return withContext(Dispatchers.IO) { // not sure if I need this
            val response: HttpResponse = client.get(BASE_URL)
            if (response.status.value == 200) {
                val dogImageResponse: DogImageResponse = response.body()
                dogImageResponse.message
            }
            "bad api call with status ${response.status.description}"
        }
    }

    fun close() {
        client.close()
    }
}