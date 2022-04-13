package com.example.mynewapplication.navigation

const val ARGUMENT_RESPONSE_KEY = "response"

sealed class Screens(
    val route: String
) {
    object Splash : Screens("splash_screen")

    object Welcome : Screens("welcome_screen")

    object Home : Screens("home_screen")

    object Chrome : Screens("chrome_screen/{$ARGUMENT_RESPONSE_KEY}") {
        fun passResponse(response: String): String {
            return this.route.replace(oldValue = "{$ARGUMENT_RESPONSE_KEY}", newValue = response)
        }
    }
}
