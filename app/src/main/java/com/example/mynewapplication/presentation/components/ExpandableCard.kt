package com.example.mynewapplication.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewapplication.ui.theme.SMALL_PADDING
import com.example.mynewapplication.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title: String = "Title",
    body: String = "Body",
    itemClickListener : () -> Unit = {  }
) {
    var isExpandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if (isExpandedState) 180f else 0f)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
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
                    text = title,
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
                        .clickable { itemClickListener }
                ) {
                    Text(
                        text = body,
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


@ExperimentalMaterialApi
@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(
        title = "title title title title title title title title title title title title title title title title title title title title ",
        body = "body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body body ",

    )
}