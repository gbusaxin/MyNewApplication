package com.example.mynewapplication.data.repository

import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.domain.repository.OnBoardingOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val onBoardingOperations: OnBoardingOperations,
    private val newsRepository: NewsRepositoryImpl
) {

    suspend fun setOnBoardingState(completed: Boolean) {
        onBoardingOperations.setOnBoardingState(completed = completed)
    }

    fun getOnBoardingState(): Flow<Boolean> {
        return onBoardingOperations.getOnBoardingState()
    }

    fun getAllNews(): Flow<List<News>> {
        return newsRepository.getAllNews()
    }

    suspend fun loadAllNews() {
        newsRepository.loadAllNews()
    }

}