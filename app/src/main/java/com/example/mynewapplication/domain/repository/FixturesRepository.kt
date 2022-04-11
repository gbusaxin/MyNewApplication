package com.example.mynewapplication.domain.repository

import com.example.mynewapplication.domain.models.Fixtures
import kotlinx.coroutines.flow.Flow

interface FixturesRepository {

    suspend fun loadAllFixtures()

    suspend fun getAllFixtures(): Flow<List<Fixtures>>

    suspend fun deleteAllFixtures()

}