package com.example.mynewapplication.domain.use_cases.load_all_results

import com.example.mynewapplication.data.repository.Repository

class LoadAllResultsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadAllResults()
}