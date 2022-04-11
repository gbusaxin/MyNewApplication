package com.example.mynewapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "results_table")
data class ResultsDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val team1: String,
    val image1: String,
    val team2: String,
    val image2: String,
    val result: String,
    val date: String,
    val group: String,
)