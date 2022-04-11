package com.example.mynewapplication.domain.use_cases.delete_all_fixtures

import com.example.mynewapplication.data.repository.Repository

class DeleteAllFixturesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.deleteAllFixtures()
}