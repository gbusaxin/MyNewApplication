package com.example.mynewapplication.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.presentation.components.ExpandableCard
import com.example.mynewapplication.ui.theme.SMALL_PADDING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

@ExperimentalMaterialApi
@Composable
fun ListNews(
//    navController: NavHostController,
    list: List<News>
) {
    val data = rememberLazyListState()
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = list,
            key = { news -> news.title }
        ) {
            it?.let {
                ExpandableCard(
                    title = it.title,
                    body = it.sDesc,
                    itemClickListener = { }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ListNewsPreview() {
    ListNews(
        list = listOf(
            News(",", "ttile", "sdesc", "", ""),
            News(",", "ttile", "sdesc", "", ""),
            News(",", "ttile", "sdesc", "", ""),
            News(",", "ttile", "sdesc", "", ""),
            News(",", "ttile", "sdesc", "", ""),
            News(",", "ttile", "sdesc", "", "")
        )
    )
}