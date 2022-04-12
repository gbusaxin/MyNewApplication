package com.example.mynewapplication.domain.use_cases

import com.example.mynewapplication.domain.use_cases.delete_all_fixtures.DeleteAllFixturesUseCase
import com.example.mynewapplication.domain.use_cases.delete_all_results.DeleteAllResultsUseCase
import com.example.mynewapplication.domain.use_cases.get_all_fixtures.GetAllFixturesUseCase
import com.example.mynewapplication.domain.use_cases.get_all_groups.GetAllGroupsUseCase
import com.example.mynewapplication.domain.use_cases.get_all_results.GetAllResultsUseCase
import com.example.mynewapplication.domain.use_cases.get_locale.GetLocaleUseCase
import com.example.mynewapplication.domain.use_cases.get_news.GetNewsUseCase
import com.example.mynewapplication.domain.use_cases.get_on_boarding_state.GetOnBoardingStateUseCase
import com.example.mynewapplication.domain.use_cases.get_selected_news.GetSelectedNewsUseCase
import com.example.mynewapplication.domain.use_cases.load_all_fixtures.LoadAllFixturesUseCase
import com.example.mynewapplication.domain.use_cases.load_all_groups.LoadAllGroupsUseCase
import com.example.mynewapplication.domain.use_cases.load_all_results.LoadAllResultsUseCase
import com.example.mynewapplication.domain.use_cases.load_news.LoadNewsUseCase
import com.example.mynewapplication.domain.use_cases.send_locale.SendLocaleUseCase
import com.example.mynewapplication.domain.use_cases.set_on_boarding_state.SetOnBoardingStateUseCase

data class UseCases(
    val setOnBoardingState: SetOnBoardingStateUseCase,
    val getOnBoardingState: GetOnBoardingStateUseCase,
    val getNewsUseCase: GetNewsUseCase,
    val loadNewsUseCase: LoadNewsUseCase,
    val getSelectedNewsUseCase: GetSelectedNewsUseCase,
    val loadAllFixturesUseCase: LoadAllFixturesUseCase,
    val getAllFixturesUseCase: GetAllFixturesUseCase,
    val deleteAllFixturesUseCase: DeleteAllFixturesUseCase,
    val getAllResultsUseCase: GetAllResultsUseCase,
    val deleteAllResultsUseCase: DeleteAllResultsUseCase,
    val loadAllResultsUseCase: LoadAllResultsUseCase,
    val loadAllGroupsUseCase: LoadAllGroupsUseCase,
    val getAllGroupsUseCase: GetAllGroupsUseCase,
    val getLocaleUseCase: GetLocaleUseCase,
    val sendLocaleUseCase: SendLocaleUseCase
)
