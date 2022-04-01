package com.example.mynewapplication.domain.use_cases.get_on_boarding_state

import com.example.mynewapplication.data.repository.Repository

class GetOnBoardingStateUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.getOnBoardingState()
}