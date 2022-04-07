package com.example.mynewapplication.presentation.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.navigation.BottomBarScreens
import com.example.mynewapplication.ui.theme.SMALL_PADDING
import com.example.mynewapplication.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    news:News,
    navController:NavHostController
) {
    var isExpandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if (isExpandedState) 180f else 0f)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = (if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray)
        ),
        onClick = {
            isExpandedState = !isExpandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SMALL_PADDING)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = news.title,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        isExpandedState = !isExpandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "icon"
                    )
                }
            }//row
            if (isExpandedState) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Log.d("CLICK_NEWS", "click -> ${news.title}")
                            navController.navigate(
                                BottomBarScreens.NewsDetail.passNewsDetail(
                                    title = news.title
                                )
                            )
                        }
                ) {
                    Text(
                        text = news.sDesc,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontWeight = FontWeight.Normal,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }//column
    }//card
}

