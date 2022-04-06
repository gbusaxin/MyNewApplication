package com.example.mynewapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object News : BottomBarScreens(
        route = "news",
        title = "Новости",
        icon = Icons.Filled.Home
    )

    object Matches : BottomBarScreens(
        route = "matches",
        title = "Матчи",
        icon = Icons.Filled.Info
    )

    object Groups : BottomBarScreens(
        route = "groups",
        title = "Группы",
        icon = Icons.Filled.Person
    )
}