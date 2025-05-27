package com.example.technicaltest_kmp.remote

import com.example.technicaltest_kmp.remote.client.MockHttpApiClient
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class VideoApiImplTest {
    @Test
    fun test() {
        runTest {
            val api = VideoApiImpl(MockHttpApiClient().get())
            val result = api.getVideoUrl()
            println(result)
        }
    }
}