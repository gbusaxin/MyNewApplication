package com.example.mynewapplication.presentation.screens.home.news.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.domain.use_cases.UseCases
import com.example.mynewapplication.utils.Constants.SELECTED_NEWS_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedNews: MutableStateFlow<News?> = MutableStateFlow(null)
    val selectedNews : StateFlow<News?> = _selectedNews

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val newsTitle = savedStateHandle.get<Int>(SELECTED_NEWS_KEY)
            _selectedNews.value = newsTitle?.let { useCases.getSelectedNewsUseCase(it) }
        }
    }

}