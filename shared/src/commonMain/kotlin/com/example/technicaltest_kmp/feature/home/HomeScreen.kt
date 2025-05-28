package com.example.technicaltest_kmp.feature.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.technicaltest_kmp.feature.home.viewmodel.VideoViewModel
import com.example.technicaltest_kmp.utils.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: VideoViewModel = koinViewModel(),
) {
}