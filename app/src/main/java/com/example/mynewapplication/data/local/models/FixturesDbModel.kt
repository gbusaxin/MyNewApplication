package com.example.mynewapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixtures_table")
data class FixturesDbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val team1: String,

    val image1: String,

    val team2: String,

    val image2: String,

    val time: String,

    val date: String
)