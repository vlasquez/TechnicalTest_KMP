package com.example.technicaltest_kmp.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoApiResponse(
    @SerialName("url")
    val videoUrl: String
)
