package com.example.mynewapplication.presentation.screens.home.news.detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.ui.theme.LARGE_PADDING
import com.example.mynewapplication.ui.theme.MEDIUM_PADDING
import com.example.mynewapplication.ui.theme.SMALL_PADDING


@ExperimentalCoilApi
@Composable
fun NewsScreenDetail(
    navController: NavHostController,
    newsDetailViewModel: NewsDetailViewModel = hiltViewModel()
) {
    val selectedNews by newsDetailViewModel.selectedNews.collectAsState()
    selectedNews?.apply {
        ContentDetail(
            navController = navController,
            title = title,
            sDesc = sDesc,
            date = date,
            description = description,
            image = image
        )
    }
}

@ExperimentalCoilApi
@Composable
fun ContentDetail(
    navController: NavHostController,
    title: String,
    sDesc: String,
    date: String,
    description: String,
    image: String
) {
    val painter = rememberImagePainter(data = image) {
        placeholder(R.drawable.ic_smile)
        error(R.drawable.ic_error)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .verticalScroll(state = rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = LARGE_PADDING,
                    bottom = MEDIUM_PADDING
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .align(Alignment.TopStart),
                        painter = painter,
                        contentDescription = "image",
                        contentScale = ContentScale.FillWidth
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        modifier = Modifier.padding(all = SMALL_PADDING),
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            imageVector = Icons.Default.Close,
                            contentDescription = "закрыть",
                            tint = Color.White
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            } //title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MEDIUM_PADDING),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = sDesc,
                    color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold
                )
            } // sDesc
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MEDIUM_PADDING, start = SMALL_PADDING),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = date,
                    color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Thin
                )
            } // date
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MEDIUM_PADDING),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = description,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            } // description
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun ContentDetailPreview() {
    ContentDetail(
        navController = rememberNavController(),
        title = "Title Title Title Title ",
        sDesc = "Title Title Title Title Title Title Title Title Title Title ",
        date = "date",
        description = "Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title ",
        image = ""
    )
}