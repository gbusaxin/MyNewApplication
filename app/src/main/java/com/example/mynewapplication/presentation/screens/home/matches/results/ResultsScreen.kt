package com.example.mynewapplication.presentation.screens.home.matches.results

import android.util.Log
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.domain.models.Results
import com.example.mynewapplication.ui.theme.SMALL_PADDING
import java.util.*

@ExperimentalCoilApi
@Composable
fun ResultsScreen(
    resultsViewModel: ResultsViewModel = hiltViewModel()
) {

    val listResults: List<Results>
            by resultsViewModel.resultsList.collectAsState(initial = Collections.emptyList())

    Log.d("CHECK_RESULT_SCREEN", listResults.toString())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {

        items(
            items = listResults
        ) {
            it?.let { result ->
                ResultsItem(
                    image1 = result.image1,
                    image2 = result.image2,
                    team1 = result.team1,
                    team2 = result.team2,
                    result = result.result,
                    date = result.date,
                    group = result.group
                )
            }
        }
    }

}

@ExperimentalCoilApi
@Composable
fun ResultsItem(
    image1: String,
    image2: String,
    team1: String,
    team2: String,
    result: String,
    date: String,
    group: String
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
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = result,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$date $group",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}