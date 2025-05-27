package com.example.technicaltest_kmp.android

import android.app.Application

class TechnicalTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInit().init {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@BloomApp)
            modules(
                listOf(
                    androidModule,
                ),
            )
        }
    }
}