package com.example.mynewapplication.domain.use_cases.get_all_results

import com.example.mynewapplication.data.repository.Repository

class GetAllResultsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllResults()
}