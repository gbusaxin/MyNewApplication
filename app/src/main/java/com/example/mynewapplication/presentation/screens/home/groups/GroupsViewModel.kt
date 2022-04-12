package com.example.mynewapplication.presentation.screens.home.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.domain.models.Group
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
class GroupsViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    private val _groupsList = MutableStateFlow<List<Group>>(Collections.emptyList())
    val groupsList: Flow<List<Group>> = _groupsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.loadAllGroupsUseCase()
            val groups = useCases.getAllGroupsUseCase()
            groups.collect {
                _groupsList.value = it
            }
        }
    }
}