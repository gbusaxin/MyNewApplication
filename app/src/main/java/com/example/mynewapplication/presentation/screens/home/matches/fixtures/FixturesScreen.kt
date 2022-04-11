package com.example.mynewapplication.presentation.screens.home.matches.fixtures

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.domain.models.Fixtures
import com.example.mynewapplication.ui.theme.SMALL_PADDING
import java.util.*

@ExperimentalCoilApi
@Composable
fun FixturesScreen(
    fixturesViewModel: FixturesViewModel = hiltViewModel()
) {

    val list: List<Fixtures>
            by fixturesViewModel.fixturesList.collectAsState(initial = Collections.emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = list
        ) {
            it?.let {
                FixturesItem(
                    image1 = it.image1,
                    image2 = it.image2,
                    team1 = it.team1,
                    team2 = it.team2,
                    date = it.date,
                    time = it.time
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun FixturesItem(
    image1: String,
    image2: String,
    team1: String,
    team2: String,
    date: String,
    time: String
) {

    val imagePainter1: ImagePainter = rememberImagePainter(data = image1) {
        placeholder(R.drawable.ic_loading)
        error(R.drawable.ic_error)
    }
    val imagePainter2: ImagePainter = rememberImagePainter(data = image2) {
        placeholder(R.drawable.ic_loading)
        error(R.drawable.ic_error)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = SMALL_PADDING)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                    painter = imagePainter1,
                    contentDescription = "image"
                )
                Text(
                    text = team1,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }//team1
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(all = SMALL_PADDING),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = team2,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Image(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                    painter = imagePainter2,
                    contentDescription = "image"
                )
            }//team2
        }//Row

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$date $time",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun FixturesItemPreview() {

    val painter1 = rememberImagePainter(
        data = "",
        builder = {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
    )

    val painter2 = rememberImagePainter(
        data = "",
        builder = {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
    )

    FixturesItem(
        image2 = "",
        image1 = "",
        team2 = "BARCELONA",
        team1 = "SPARTAK",
        time = "20.20.2020 nfeowfe",
        date = "20-00"
    )
}