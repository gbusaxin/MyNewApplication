package com.example.mynewapplication.domain.use_cases.set_on_boarding_state

import com.example.mynewapplication.data.repository.Repository

class SetOnBoardingStateUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) =
        repository.setOnBoardingState(completed = completed)
}