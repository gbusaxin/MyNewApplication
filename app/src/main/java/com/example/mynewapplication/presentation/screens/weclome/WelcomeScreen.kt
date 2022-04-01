package com.example.mynewapplication.presentation.screens.weclome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mynewapplication.domain.models.OnBoardingPage

@Composable
fun WelcomeScreen(
    navController: NavHostController
) {

    val pages = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage

    )

}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
    }
}