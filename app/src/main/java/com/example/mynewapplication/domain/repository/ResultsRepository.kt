package com.example.mynewapplication.domain.repository

import com.example.mynewapplication.domain.models.Results
import kotlinx.coroutines.flow.Flow

interface ResultsRepository {

    suspend fun loadAllResults()

    suspend fun getAllResults(): Flow<List<Results>>

    suspend fun deleteAllResults()

}