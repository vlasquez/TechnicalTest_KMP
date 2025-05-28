package com.example.technicaltest_kmp.feature.home.viewmodel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.technicaltest_kmp.presentation.MainScreen
import com.example.technicaltest_kmp.ui.AppTheme
import com.example.technicaltest_kmp.utils.koinViewModel
import org.koin.compose.KoinContext

@Composable
fun App(videoViewModel: VideoViewModel = koinViewModel()) {

    KoinContext {
        AppTheme {
            val navController = rememberNavController()
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                MainScreen(navController = navController)
            }
        }
    }

}