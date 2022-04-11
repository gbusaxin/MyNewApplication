package com.example.mynewapplication.domain.use_cases.load_all_fixtures

import com.example.mynewapplication.data.repository.Repository

class LoadAllFixturesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadAllFixtures()
}