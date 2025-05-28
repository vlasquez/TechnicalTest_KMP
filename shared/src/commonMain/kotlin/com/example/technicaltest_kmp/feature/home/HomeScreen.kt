package com.example.technicaltest_kmp.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.technicaltest_kmp.domain.model.Video
import com.example.technicaltest_kmp.feature.home.viewmodel.VideoViewModel
import com.example.technicaltest_kmp.presentation.navigation.Destinations
import com.example.technicaltest_kmp.utils.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: VideoViewModel = koinViewModel(),
) {
    val viewState = viewModel.viewState.collectAsState()
    var video by remember {
        mutableStateOf<Video?>(null)
    }

    when (viewState.value) {
        is VideoViewModel.ViewState.Success -> {
            video = (viewState.value as VideoViewModel.ViewState.Success).video
        }

        is VideoViewModel.ViewState.Error -> {

        }

        VideoViewModel.ViewState.Loading -> {

        }
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            modifier = Modifier,
            text = "Video Stream",
            style = MaterialTheme.typography.headlineLarge
        )

        Button(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.getVideoUrl()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            content = {
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    text = "Fetch Stream",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                )
            })
        video?.let {
            Text(
                modifier = Modifier,
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
                        )
                    ) {
                        append("Video Stream URL:\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
                        )
                    ) {
                        append(it.url)
                    }
                },

                style = MaterialTheme.typography.bodyLarge
            )

            Button(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Destinations.VideoPlayer(it.url))
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                content = {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = "Play Stream",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                })
        }
    }
}