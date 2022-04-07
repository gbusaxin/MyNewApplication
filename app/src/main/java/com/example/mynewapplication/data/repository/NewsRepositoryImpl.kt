package com.example.mynewapplication.data.repository

import android.util.Log
import com.example.mynewapplication.data.local.AppDatabase
import com.example.mynewapplication.data.mappers.NewsMapper
import com.example.mynewapplication.data.remote.ApiService
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    database: AppDatabase,
    private val apiService: ApiService,
    private val newsMapper: NewsMapper
) : NewsRepository {

    private val dao = database.getDao()

    override suspend fun loadAllNews() {
        val dto = apiService.getAllNews()
        Log.d("CHECK_NEWS_DTO", dto.toString())
        val dbModel = dto.map { newsMapper.mapDtoToDbModel(it) }
        Log.d("CHECK_NEWS_DB", dbModel.toString())
        dao.insertAllNews(dbModel)
    }

    override suspend fun getAllNews(): Flow<List<News>> {
        val dbModel = dao.getAllNews()
        val qwe = MutableStateFlow(
            dbModel.map { newsMapper.mapDbModelToEntity(it) }
        )
        return qwe.asStateFlow()
    }

    override suspend fun getSelectedNews(title: String): News {
        return newsMapper.mapDbModelToEntity(dao.getSelectedNews(title = title))
    }
}