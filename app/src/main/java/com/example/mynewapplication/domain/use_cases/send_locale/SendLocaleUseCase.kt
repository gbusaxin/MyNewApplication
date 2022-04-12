package com.example.mynewapplication.domain.use_cases.send_locale

import com.example.mynewapplication.data.repository.Repository

class SendLocaleUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.sendLocale()
}