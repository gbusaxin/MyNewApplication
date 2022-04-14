package com.example.mynewapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynewapplication.data.local.models.NewsDbModel

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_table")
    fun getAllNews(): List<NewsDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(news: List<NewsDbModel>)

    @Query("SELECT * FROM news_table WHERE id =:id")
    suspend fun getSelectedNews(id: Int): NewsDbModel

    @Query("DELETE FROM news_table")
    suspend fun deleteAllNews()

}