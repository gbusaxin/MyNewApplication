package com.example.mynewapplication.presentation.screens.home.news

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.presentation.common.ListNews
import java.util.*

@ExperimentalMaterialApi
@Composable
fun NewsScreen(
    navController: NavHostController,
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val news: List<News> by newsViewModel.newsList.collectAsState(initial = Collections.emptyList())
    ListNews(
        list = news,
        navController = navController
    )

}