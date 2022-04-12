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
            _serverResponse.value = useCases.sendLocaleUseCase().url
            Log.d("CHECK_RESP_CHROME",_serverResponse.value)
            _onBoardingCompleted.value =
                useCases.getOnBoardingState().stateIn(viewModelScope).value
        }
    }
}