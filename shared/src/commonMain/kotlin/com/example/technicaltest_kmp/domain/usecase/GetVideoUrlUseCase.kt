package com.example.technicaltest_kmp.domain.usecase

import com.example.technicaltest_kmp.data.VideoRepository
import com.example.technicaltest_kmp.domain.model.Video

class GetVideoUrlUseCase(private val videoRepository: VideoRepository) {

    suspend operator fun invoke(): Result<Video> {
        return videoRepository.getVideoUrl()
    }
}