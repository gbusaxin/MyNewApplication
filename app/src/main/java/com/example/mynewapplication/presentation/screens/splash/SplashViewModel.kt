package com.example.mynewapplication.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

    private val _serverResponse = MutableStateFlow("")
    val serverResponse: StateFlow<String> = _serverResponse

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val encodedResponse = URLEncoder.encode(
                useCases.sendLocaleUseCase().url,
                StandardCharsets.UTF_8.toString()
            )
            _serverResponse.value = encodedResponse
            _onBoardingCompleted.value =
                useCases.getOnBoardingState().stateIn(viewModelScope).value
        }
    }
}