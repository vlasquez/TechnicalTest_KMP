package com.example.technicaltest_kmp

import com.example.technicaltest_kmp.domain.usecase.GetVideoUrlUseCase
import org.koin.android.ext.android.inject
import kotlin.getValue

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()