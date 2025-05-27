package com.example.technicaltest_kmp.remote.di

import com.example.technicaltest_kmp.remote.VideoApi
import com.example.technicaltest_kmp.remote.VideoApiImpl
import com.example.technicaltest_kmp.remote.client.MockHttpApiClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

fun networkingModule() = module {
    single<MockHttpApiClient>(qualifier("mockHttpClient")) { MockHttpApiClient() }
    single<HttpClientEngine> { get<MockHttpApiClient>(qualifier("mockHttpClient")).get() }
    single<VideoApi> { VideoApiImpl(get()) }
}