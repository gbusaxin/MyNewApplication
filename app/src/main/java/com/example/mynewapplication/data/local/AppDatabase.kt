package com.example.mynewapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynewapplication.data.local.models.FixturesDbModel
import com.example.mynewapplication.data.local.models.NewsDbModel
import com.example.mynewapplication.data.local.models.ResultsDbModel

@Database(
    entities = [
        NewsDbModel::class,
        FixturesDbModel::class,
        ResultsDbModel::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
    abstract fun getFixturesDao(): FixturesDao
    abstract fun getResultsDao(): ResultsDao
}