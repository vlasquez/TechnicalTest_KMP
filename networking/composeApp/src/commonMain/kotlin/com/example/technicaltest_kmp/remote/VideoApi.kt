package com.example.technicaltest_kmp.remote

import com.example.technicaltest_kmp.remote.model.VideoApiResponse

interface VideoApi {
    suspend fun getVideoUrl(): Result<VideoApiResponse>
}
