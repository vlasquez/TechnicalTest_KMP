package com.example.technicaltest_kmp.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.technicaltest_kmp.Greeting
import com.example.technicaltest_kmp.domain.model.Video
import com.example.technicaltest_kmp.domain.usecase.GetVideoUrlUseCase
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val getVideoUrlUseCase: GetVideoUrlUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val video = remember { mutableStateOf<Video?>(null) }
                    LaunchedEffect(video) {
                        lifecycleScope.launch {
                            getVideoUrlUseCase().onSuccess { videoUrl ->
                                video.value = videoUrl
                            }.onFailure { exception ->
                                Log.e("VIDEOAPI", exception.message ?: "")
                            }
                        }
                    }

                    GreetingView(Greeting().greet() + video.value?.url)
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
