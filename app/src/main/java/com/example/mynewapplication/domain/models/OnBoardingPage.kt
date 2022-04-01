package com.example.mynewapplication.domain.models

import androidx.annotation.DrawableRes
import com.example.mynewapplication.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object FirstPage : OnBoardingPage(
        image = R.drawable.ic_smile,
        title = "Welcome!",
        description = "Добро пожаловать!"
    )

    object SecondPage : OnBoardingPage(
        image = R.drawable.ic_heart,
        title = "Футбол",
        description = "Футбол - это тематика приложения"
    )

    object ThirdPage : OnBoardingPage(
        image = R.drawable.ic_like,
        title = "Пожелания",
        description = "Надеемся вам понравится это приложение"
    )
}

