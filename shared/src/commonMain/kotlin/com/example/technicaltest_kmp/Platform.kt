package com.example.technicaltest_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform