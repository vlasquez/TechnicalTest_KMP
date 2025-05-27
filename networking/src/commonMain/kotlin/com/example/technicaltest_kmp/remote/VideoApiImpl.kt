package com.example.technicaltest_kmp.remote

import com.example.technicaltest_kmp.remote.model.VideoApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json

class VideoApiImpl(httpClientEngine: HttpClientEngine) : VideoApi {

    private val client = HttpClient(httpClientEngine) {
        install(ContentNegotiation) {
            json()
        }
    }

    override suspend fun getVideoUrl(): Result<VideoApiResponse> {
        return try {
            Result.success(client.get {
                url("video")
            }.body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun HttpRequestBuilder.url(path: String) {
        url {
            takeFrom("https://www.example.com/v1/")
            encodedPath = path
        }
    }
}