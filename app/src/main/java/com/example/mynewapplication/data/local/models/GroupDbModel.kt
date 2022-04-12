package com.example.mynewapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mynewapplication.data.local.converters.GroupConverter
import com.example.mynewapplication.domain.models.Team

@Entity(tableName = "group_table")
@TypeConverters(GroupConverter::class)
data class GroupDbModel(
    @PrimaryKey(autoGenerate = false)
    val group: String,
    val teams: List<Team>,
)