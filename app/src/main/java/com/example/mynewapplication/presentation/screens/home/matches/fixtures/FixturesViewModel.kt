package com.example.mynewapplication.presentation.screens.home.matches.fixtures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.domain.models.Fixtures
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
class FixturesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _fixturesList = MutableStateFlow<List<Fixtures>>(Collections.emptyList())
    val fixturesList: Flow<List<Fixtures>> = _fixturesList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteAllFixturesUseCase()
            useCases.loadAllFixturesUseCase()
            val fl = useCases.getAllFixturesUseCase()
            fl.collect {
                _fixturesList.value = it
            }
        }
    }
}