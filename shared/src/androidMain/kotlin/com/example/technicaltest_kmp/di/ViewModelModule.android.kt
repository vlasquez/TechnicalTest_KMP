package com.example.technicaltest_kmp.di

import com.example.technicaltest_kmp.feature.home.viewmodel.VideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::VideoViewModel)
}