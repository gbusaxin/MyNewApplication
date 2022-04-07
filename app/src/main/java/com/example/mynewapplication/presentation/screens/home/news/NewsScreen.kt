package com.example.mynewapplication.presentation.screens.home.news

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.presentation.common.ListNews
import kotlinx.coroutines.flow.collect
import java.util.*

@ExperimentalMaterialApi
@Composable
fun NewsScreen(
    navController: NavHostController,
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    Log.d("CHECK_MODEL_VER",newsViewModel.toString())
    val news: List<News> by newsViewModel.newsList.collectAsState(initial = Collections.emptyList())
    Log.d("CHECK_NEWS_SCREEN",news.toString())
    ListNews(
        list = news,
        navController = navController
    )

}