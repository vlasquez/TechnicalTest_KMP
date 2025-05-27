package com.example.technicaltest_kmp.di

import com.example.technicaltest_kmp.domain.usecase.GetVideoUrlUseCase
import org.koin.dsl.module

fun videoModule() = module {
    single { GetVideoUrlUseCase(get()) }
}