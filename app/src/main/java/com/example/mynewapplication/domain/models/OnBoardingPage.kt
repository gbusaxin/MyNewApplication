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
        title = "Благодарность",
        description = "Спасибо что скачали наше приложение"
    )

    object ThirdPage : OnBoardingPage(
        image = R.drawable.ic_like,
        title = "Футбол",
        description = "- это тематика приложения"
    )
}

