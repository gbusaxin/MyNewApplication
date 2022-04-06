package com.example.mynewapplication.domain.repository

import com.example.mynewapplication.domain.models.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun loadAllNews()

    fun getAllNews(): Flow<List<News>>

}