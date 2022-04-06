package com.example.mynewapplication.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mynewapplication.presentation.screens.home.groups.GroupsScreen
import com.example.mynewapplication.presentation.screens.home.matches.MatchesScreen
import com.example.mynewapplication.presentation.screens.home.news.NewsScreen

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
        ){
            NewsScreen(
                navController = navController
            )
        }
        composable(
            route = BottomBarScreens.Matches.route
        ){
            MatchesScreen()
        }
        composable(
            route = BottomBarScreens.Groups.route
        ){
            GroupsScreen()
        }
    }
}