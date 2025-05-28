package com.example.technicaltest_kmp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Home

    @Serializable
    data class VideoPlayer(val videoUrl: String)
}