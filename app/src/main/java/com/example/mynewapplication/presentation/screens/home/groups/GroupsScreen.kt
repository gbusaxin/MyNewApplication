package com.example.mynewapplication.presentation.screens.home.groups

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.domain.models.Group
import com.example.mynewapplication.ui.theme.MEDIUM_PADDING
import com.example.mynewapplication.ui.theme.SMALL_PADDING
import com.example.mynewapplication.ui.theme.Shapes
import java.util.*

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun GroupsScreen(
    groupsViewModel: GroupsViewModel = hiltViewModel()
) {

    val list: List<Group> by groupsViewModel.groupsList.collectAsState(initial = Collections.emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {

        list.forEach { group ->
            stickyHeader {
                Text(
                    text = group.group,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            }
            items(
                items = group.teams
            ) { team ->
                GroupItem(
                    image = team.image,
                    team = team.team
                )
            }
        }
    }

}

@ExperimentalCoilApi
@Composable
fun GroupItem(
    image: String,
    team: String
) {

    val painter = rememberImagePainter(data = image) {
        placeholder(R.drawable.ic_loading)
        error(R.drawable.ic_error)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = MEDIUM_PADDING)
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray),
        shape = Shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = SMALL_PADDING)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painter,
                    contentDescription = "image"
                )
                Text(
                    text = team,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}