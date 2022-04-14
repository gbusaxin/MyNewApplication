package com.example.mynewapplication.presentation.screens.home.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.domain.models.News
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
class NewsViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    private var _newsList = MutableStateFlow<List<News>>(Collections.emptyList())
    val newsList: Flow<List<News>> = _newsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteAllNewsUseCase()
            useCases.loadNewsUseCase()
            val fl = useCases.getNewsUseCase()
            fl.collect {
                _newsList.value = it
            }
        }
    }
}