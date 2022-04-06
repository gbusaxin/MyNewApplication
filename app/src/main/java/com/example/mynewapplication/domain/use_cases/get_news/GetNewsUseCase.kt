package com.example.mynewapplication.domain.use_cases.get_news

import com.example.mynewapplication.data.repository.Repository

class GetNewsUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.getAllNews()
}