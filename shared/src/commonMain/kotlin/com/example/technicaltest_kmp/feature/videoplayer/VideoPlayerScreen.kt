package com.example.technicaltest_kmp.feature.videoplayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.navigation.NavController
import com.example.technicaltest_kmp.ui.composable.VideoPlayerTopAppBar


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun VideoPlayerScreen(
    navController: NavController,
    videoUrl: String
) {
    BackHandler(enabled = true, onBack = {
        navController.popBackStack()
    })

    Scaffold(
        topBar = {
            VideoPlayerTopAppBar(
                hasBackNavigation = true,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(text = "Video Player")
                }
            )
        },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            VideoPlayer(videoUrl = videoUrl, modifier = Modifier)
        }
    }
}