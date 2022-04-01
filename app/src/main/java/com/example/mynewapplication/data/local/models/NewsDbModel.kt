package com.example.mynewapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsDbModel(
    @PrimaryKey(autoGenerate = false)
    val image: String,

    val title: String,

    val sDesc: String,

    val date: String,

    val description: String
)