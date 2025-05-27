package com.example.technicaltest_kmp.remote.client

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*

class ApiMockEngine {
    fun get() = client.engine

    private val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
    private val client = HttpClient(MockEngine) {
        engine {
            addHandler { request ->
                if (request.url.encodedPath == "/video") {
                    respond(
                        content = """{"url": "https://example.com/video"}""",
                        status = HttpStatusCode.OK,
                        headers = responseHeaders
                    )
                } else {
                    respondError(HttpStatusCode.NotFound)
                }
            }
        }
    }
}