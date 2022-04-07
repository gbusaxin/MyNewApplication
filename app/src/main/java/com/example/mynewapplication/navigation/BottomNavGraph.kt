package com.example.mynewapplication.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mynewapplication.presentation.screens.home.groups.GroupsScreen
import com.example.mynewapplication.presentation.screens.home.matches.MatchesScreen
import com.example.mynewapplication.presentation.screens.home.news.NewsScreen
import com.example.mynewapplication.presentation.screens.home.news.detail.NewsScreenDetail
import com.example.mynewapplication.utils.Constants.SELECTED_NEWS_KEY

@ExperimentalMaterialApi
@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.News.route
    ) {
        composable(
            route = BottomBarScreens.News.route
        ) {
            NewsScreen(
                navController = navController
            )
        }
        composable(
            route = BottomBarScreens.NewsDetail.route,
            arguments = listOf(navArgument(SELECTED_NEWS_KEY) {
                type = NavType.StringType
            })
        ) {
            NewsScreenDetail(
                navController = navController
            )
        }
        composable(
            route = BottomBarScreens.Matches.route
        ) {
            MatchesScreen()
        }
        composable(
            route = BottomBarScreens.Groups.route
        ) {
            GroupsScreen()
        }
    }
}