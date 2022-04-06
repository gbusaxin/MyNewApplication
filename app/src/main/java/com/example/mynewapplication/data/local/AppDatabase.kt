package com.example.mynewapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynewapplication.data.local.models.NewsDbModel

@Database(
    entities = [
        NewsDbModel::class
               ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getDao():DbDao

}