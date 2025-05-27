package com.example.technicaltest_kmp.domain.model

import com.example.technicaltest_kmp.remote.model.VideoApiResponse

fun VideoApiResponse.toVideo(): Video {
    return Video(
        url = this.videoUrl
    )
}