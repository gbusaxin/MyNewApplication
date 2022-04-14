package com.example.mynewapplication.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.navigation.BottomBarScreens
import com.example.mynewapplication.presentation.components.ExpandableCard
import com.example.mynewapplication.ui.theme.SMALL_PADDING

@ExperimentalMaterialApi
@Composable
fun ListNews(
    navController: NavHostController,
    list: List<News>
) {
    LazyColumn(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = list,
            key = { news -> news.title }
        ) {
            it?.let {
                ExpandableCard(
                    news = it,
                    navController = navController
                )
            }
        }
    }
}
