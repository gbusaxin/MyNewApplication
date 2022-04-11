package com.example.mynewapplication.domain.use_cases.get_all_fixtures

import com.example.mynewapplication.data.repository.Repository

class GetAllFixturesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllFixtures()
}