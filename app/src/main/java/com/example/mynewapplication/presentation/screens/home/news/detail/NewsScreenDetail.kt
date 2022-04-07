package com.example.mynewapplication.presentation.screens.home.news.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.ui.theme.LARGE_PADDING
import com.example.mynewapplication.ui.theme.MEDIUM_PADDING


@Composable
fun NewsScreenDetail(
    navController: NavController,
    newsDetailViewModel: NewsDetailViewModel = hiltViewModel()
) {

    val selectedNews by newsDetailViewModel.selectedNews.collectAsState()
    Log.d("CHECK_SELECTED_SCREEN", selectedNews.toString())

}

@Composable
fun ContentDetail(
    news: News,
    scrollableState: Float = 0f,
    title: String,
    sDesc: String,
    date: String,
    description: String
) {

    val scroll = rememberScrollableState(consumeScrollDelta = { scrollableState })

    val painter = rememberImagePainter(data = news.image) {
        placeholder(R.drawable.ic_smile)
        error(R.drawable.ic_error)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scroll,
                orientation = Orientation.Vertical
            )
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painter,
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )//image
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MEDIUM_PADDING)
        ) {
            Text(
                text = title,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = sDesc,
                color = if (isSystemInDarkTheme()) Color.White else Color.DarkGray,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold
            )

        }
    }

}