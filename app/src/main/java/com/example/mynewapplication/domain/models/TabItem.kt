package com.example.mynewapplication.domain.models

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import com.example.mynewapplication.presentation.screens.home.matches.fixtures.FixturesScreen
import com.example.mynewapplication.presentation.screens.home.matches.results.ResultsScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {

    @ExperimentalCoilApi
    object Fixtures : TabItem("Будущие", { FixturesScreen() })

    @ExperimentalCoilApi
    object Results : TabItem("Результаты", { ResultsScreen() })

}
