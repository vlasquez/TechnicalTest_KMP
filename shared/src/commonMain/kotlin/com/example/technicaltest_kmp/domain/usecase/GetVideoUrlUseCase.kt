package com.example.technicaltest_kmp.domain.usecase

import com.example.technicaltest_kmp.domain.model.Video
import com.example.technicaltest_kmp.domain.model.toVideo
import com.example.technicaltest_kmp.remote.VideoApi

class GetVideoUrlUseCase(private val videoApi: VideoApi) {

    suspend operator fun invoke(): Result<Video> {
        return videoApi.getVideoUrl().map { videoApiResponse -> videoApiResponse.toVideo() }
    }
}