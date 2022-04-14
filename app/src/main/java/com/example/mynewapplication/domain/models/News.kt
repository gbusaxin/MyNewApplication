package com.example.mynewapplication.domain.models

import kotlinx.serialization.Serializable


@Serializable
data class News(
    val id:Int,

    val image: String,

    val title: String,

    val sDesc: String,

    val date: String,

    val description: String
)