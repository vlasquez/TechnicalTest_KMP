package com.example.technicaltest_kmp.di

import com.example.technicaltest_kmp.remote.di.networkingModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class Koin {
    fun init(appDeclaration: KoinAppDeclaration = {}): Koin {
        return startKoin {
            modules(
                listOf(
                    networkingModule(),
                    videoModule(),
                    viewModelModule
                ),
            )
            appDeclaration()
        }.koin
    }
}