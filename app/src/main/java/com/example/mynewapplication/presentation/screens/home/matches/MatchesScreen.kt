package com.example.mynewapplication.presentation.screens.home.matches

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.annotation.ExperimentalCoilApi
import com.example.mynewapplication.domain.models.TabItem
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun MatchesScreen() {

    val tabs = listOf(
        TabItem.Results,
        TabItem.Fixtures
    )

    val pagerState = rememberPagerState()

    Scaffold {
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabSelectedContent(tabs = tabs, pagerState = pagerState)
        }
    }

}

@ExperimentalPagerApi
@Composable
fun TabSelectedContent(
    tabs: List<TabItem>,
    pagerState: PagerState
) {
    HorizontalPager(
        state = pagerState,
        count = tabs.size
    ) { page ->
        tabs[page].screen()
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
        contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions
                )
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(text = tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }

}