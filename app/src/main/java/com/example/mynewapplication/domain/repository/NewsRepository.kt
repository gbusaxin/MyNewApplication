package com.example.mynewapplication.domain.repository

import com.example.mynewapplication.domain.models.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun loadAllNews()

    suspend fun getAllNews(): Flow<List<News>>

    suspend fun getSelectedNews(title:String) : News

}