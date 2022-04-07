package com.example.mynewapplication.domain.use_cases.get_selected_news

import com.example.mynewapplication.data.repository.Repository

class GetSelectedNewsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(title: String) = repository.getSelectedNews(title)
}