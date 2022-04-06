package com.example.mynewapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.mynewapplication.presentation.screens.home.HomeScreen
import com.example.mynewapplication.presentation.screens.splash.SplashScreen
import com.example.mynewapplication.presentation.screens.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(
            route = Screens.Splash.route
        ) {
            SplashScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.Welcome.route
        ) {
            WelcomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen()
        }
    }
}