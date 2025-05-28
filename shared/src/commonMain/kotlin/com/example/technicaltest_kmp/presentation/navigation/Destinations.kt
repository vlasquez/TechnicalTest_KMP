package com.example.technicaltest_kmp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Home

    @Serializable
    object VideoPlayer
}