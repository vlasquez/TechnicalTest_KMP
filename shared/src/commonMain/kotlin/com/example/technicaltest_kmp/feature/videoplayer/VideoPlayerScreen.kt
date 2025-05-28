package com.example.technicaltest_kmp.feature.videoplayer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.technicaltest_kmp.ui.composable.VideoPlayerTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoPlayerScreen(
    navController: NavController
) {
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

        Text(text = "Video Player")
    }
}