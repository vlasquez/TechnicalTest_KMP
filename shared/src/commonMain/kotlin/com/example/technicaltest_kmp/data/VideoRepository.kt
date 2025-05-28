package com.example.technicaltest_kmp.data

import com.example.technicaltest_kmp.domain.model.Video

interface VideoRepository {
    suspend fun getVideoUrl(): Result<Video>
}