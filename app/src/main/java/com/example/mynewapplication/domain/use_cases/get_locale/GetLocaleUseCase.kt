package com.example.mynewapplication.domain.use_cases.get_locale

import com.example.mynewapplication.data.repository.Repository

class GetLocaleUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.getLocale()
}