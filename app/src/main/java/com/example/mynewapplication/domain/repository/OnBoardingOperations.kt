package com.example.mynewapplication.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingOperations {
    suspend fun setOnBoardingState(completed: Boolean)
    fun getOnBoardingState(): Flow<Boolean>
}