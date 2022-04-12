package com.example.mynewapplication.navigation

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.mynewapplication.presentation.screens.chrome.ChromeScreen
import com.example.mynewapplication.presentation.screens.home.HomeScreen
import com.example.mynewapplication.presentation.screens.splash.SplashScreen
import com.example.mynewapplication.presentation.screens.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    context: Activity
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
        composable(
            route = Screens.Chrome.route,
            arguments = listOf(navArgument("serversResponse") {
                type = NavType.StringType
            })
        ) {
            ChromeScreen(
                navController = navController,
                context = context
            )
        }
    }
}