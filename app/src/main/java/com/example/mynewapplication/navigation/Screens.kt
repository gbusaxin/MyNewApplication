package com.example.mynewapplication.navigation

sealed class Screens(
    val route: String
) {
    object Splash : Screens("splash_screen")

    object Welcome : Screens("welcome_screen")

    object Home : Screens("home_screen")
}
