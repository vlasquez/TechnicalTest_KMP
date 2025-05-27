package com.example.technicaltest_kmp.android

import android.app.Application
import com.example.technicaltest_kmp.android.di.androidModule
import com.example.technicaltest_kmp.di.Koin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class TechnicalTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Koin().init {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@TechnicalTestApplication)
        }
    }
}