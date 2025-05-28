package com.example.technicaltest_kmp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.technicaltest_kmp.presentation.navigation.AppNavHost


@Composable
fun MainScreen(
    navController: NavHostController
) {
    Scaffold(content = { innerPadding ->
        AppNavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
        )
    })

}
