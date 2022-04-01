package com.example.mynewapplication.data.local

import androidx.room.Dao
import androidx.room.Query
import com.example.mynewapplication.data.local.models.NewsDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM news_table")
    fun getAllNews(): List<NewsDbModel>

}