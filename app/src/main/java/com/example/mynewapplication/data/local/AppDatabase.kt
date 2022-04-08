package com.example.mynewapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynewapplication.data.local.models.FixturesDbModel
import com.example.mynewapplication.data.local.models.NewsDbModel

@Database(
    entities = [
        NewsDbModel::class,
        FixturesDbModel::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

}