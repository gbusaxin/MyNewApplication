package com.example.mynewapplication.domain.use_cases.load_news

import com.example.mynewapplication.data.repository.Repository

class LoadNewsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadAllNews()
}