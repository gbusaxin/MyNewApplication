package com.example.mynewapplication.domain.use_cases

import com.example.mynewapplication.domain.use_cases.get_on_boarding_state.GetOnBoardingStateUseCase
import com.example.mynewapplication.domain.use_cases.set_on_boarding_state.SetOnBoardingStateUseCase

data class UseCases(
    val setOnBoardingState: SetOnBoardingStateUseCase,
    val getOnBoardingState: GetOnBoardingStateUseCase
)
