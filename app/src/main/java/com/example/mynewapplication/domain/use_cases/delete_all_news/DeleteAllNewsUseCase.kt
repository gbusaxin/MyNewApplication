package com.example.mynewapplication.domain.use_cases.delete_all_news

import com.example.mynewapplication.data.repository.Repository

class DeleteAllNewsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.deleteAllNews()
}