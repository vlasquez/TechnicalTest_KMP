package com.example.technicaltest_kmp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.technicaltest_kmp.feature.home.HomeScreen
import com.example.technicaltest_kmp.feature.videoplayer.VideoPlayerScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Destinations.Home
    ) {

        composable<Destinations.Home> {
            HomeScreen(navController = navController)
        }

        composable<Destinations.VideoPlayer> { backStackEntry ->
            val videoUrl = backStackEntry.arguments?.getString("videoUrl")
            videoUrl?.let {
                VideoPlayerScreen(navController = navController, videoUrl = videoUrl)
            }
        }
    }
}