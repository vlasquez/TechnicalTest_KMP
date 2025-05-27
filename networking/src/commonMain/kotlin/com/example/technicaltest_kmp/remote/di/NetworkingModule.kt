package com.example.technicaltest_kmp.remote.di

import com.example.technicaltest_kmp.remote.VideoApi
import com.example.technicaltest_kmp.remote.VideoApiImpl
import com.example.technicaltest_kmp.remote.client.MockHttpApiClient
import org.koin.dsl.module

fun networkingModule() = module {
    single<MockHttpApiClient> { MockHttpApiClient() }
    single<VideoApi> { VideoApiImpl(get()) }
}