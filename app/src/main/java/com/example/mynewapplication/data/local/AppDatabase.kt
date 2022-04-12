package com.example.mynewapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynewapplication.data.local.models.FixturesDbModel
import com.example.mynewapplication.data.local.models.GroupDbModel
import com.example.mynewapplication.data.local.models.NewsDbModel
import com.example.mynewapplication.data.local.models.ResultsDbModel

@Database(
    entities = [
        NewsDbModel::class,
        FixturesDbModel::class,
        ResultsDbModel::class,
        GroupDbModel::class
    ],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
    abstract fun getFixturesDao(): FixturesDao
    abstract fun getResultsDao(): ResultsDao
    abstract fun getGroupDao(): GroupDao
}