package com.example.technicaltest_kmp.data

import com.example.technicaltest_kmp.domain.model.Video
import com.example.technicaltest_kmp.domain.model.toVideo
import com.example.technicaltest_kmp.remote.VideoApi

class VideoRepositoryImpl(private val videoApi: VideoApi) : VideoRepository {

    override suspend fun getVideoUrl(): Result<Video> {
        return videoApi.getVideoUrl().map { videoApiResponse -> videoApiResponse.toVideo() }
    }
}