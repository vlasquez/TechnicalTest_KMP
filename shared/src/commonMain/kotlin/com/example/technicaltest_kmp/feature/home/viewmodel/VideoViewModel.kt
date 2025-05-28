package com.example.technicaltest_kmp.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltest_kmp.domain.model.Video
import com.example.technicaltest_kmp.domain.usecase.GetVideoUrlUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class VideoViewModel(private val getVideoUrlUseCase: GetVideoUrlUseCase) : ViewModel(), KoinComponent {

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState: StateFlow<ViewState> = _viewState

    fun getVideoUrl() {
        viewModelScope.launch {
            getVideoUrlUseCase().onSuccess { video ->
                _viewState.value = ViewState.Success(video)
            }.onFailure { exception ->
                _viewState.value = ViewState.Error(exception)
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(val video: Video) : ViewState()
        data class Error(val exception: Throwable) : ViewState()
    }
}