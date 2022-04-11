package com.example.mynewapplication.domain.use_cases.delete_all_results

import com.example.mynewapplication.data.repository.Repository

class DeleteAllResultsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.deleteAllResults()
}