package com.github.maiatoday.hellojewel.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
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

    suspend fun getRandomDogImage(): String {
        val response: HttpResponse = client.get(BASE_URL)
        if (response.status.value == 200) {
            val dogImageResponse: DogImageResponse = response.body()
            return dogImageResponse.message
        }
        return "bad api call with status ${response.status.description}"
    }

    fun close() {
        client.close()
    }
}