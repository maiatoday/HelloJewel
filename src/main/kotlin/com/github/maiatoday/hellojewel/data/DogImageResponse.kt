package com.github.maiatoday.hellojewel.data

import kotlinx.serialization.Serializable

@Serializable
data class DogImageResponse(
    val message: String,
    val status: String
)