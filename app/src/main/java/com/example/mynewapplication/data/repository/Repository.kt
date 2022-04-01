package com.example.mynewapplication.data.repository

import com.example.mynewapplication.domain.repository.OnBoardingOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val onBoardingOperations: OnBoardingOperations
) {

    suspend fun setOnBoardingState(completed: Boolean) {
        onBoardingOperations.setOnBoardingState(completed = completed)
    }

    fun getOnBoardingState(): Flow<Boolean> {
        return onBoardingOperations.getOnBoardingState()
    }

}