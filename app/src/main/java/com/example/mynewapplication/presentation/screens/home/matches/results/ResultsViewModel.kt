package com.example.mynewapplication.presentation.screens.home.matches.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.domain.models.Results
import com.example.mynewapplication.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _resultsList = MutableStateFlow<List<Results>>(Collections.emptyList())
    val resultsList: Flow<List<Results>> = _resultsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteAllResultsUseCase
            useCases.loadAllResultsUseCase
            val results = useCases.getAllResultsUseCase()
            results.collect {
                _resultsList.value = it
            }
        }
    }
}