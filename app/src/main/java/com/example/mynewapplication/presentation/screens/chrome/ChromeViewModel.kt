package com.example.mynewapplication.presentation.screens.chrome

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.utils.Constants.SERVER_RESPONSE_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChromeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _linkResponse: MutableStateFlow<String?> = MutableStateFlow(null)
    val linkResponse: StateFlow<String?> = _linkResponse

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val key = savedStateHandle.get<String>("serversResponse")
            Log.d("CHECK_RESP_KEY", key ?: "null")
            _linkResponse.value = key
            Log.d("CHECK_RESP_KEY",linkResponse.value?:"NULL" )
        }
    }
}