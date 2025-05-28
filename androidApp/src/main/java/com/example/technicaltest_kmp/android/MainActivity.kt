package com.example.technicaltest_kmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.technicaltest_kmp.domain.usecase.GetVideoUrlUseCase
import com.example.technicaltest_kmp.feature.home.viewmodel.App
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val getVideoUrlUseCase: GetVideoUrlUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
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
