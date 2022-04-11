package com.example.mynewapplication.data.repository

import android.util.Log
import com.example.mynewapplication.data.local.AppDatabase
import com.example.mynewapplication.data.mappers.ResultsMapper
import com.example.mynewapplication.data.remote.ApiService
import com.example.mynewapplication.domain.models.Results
import com.example.mynewapplication.domain.repository.ResultsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ResultsRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: ApiService,
    private val resultsMapper: ResultsMapper
) : ResultsRepository {

    private val dao = database.getResultsDao()

    override suspend fun loadAllResults() {
        Log.d("CHECK_API_SERVISE", apiService.toString())
        val dto = apiService.getAllResults()
        val dbModel = dto.map { resultsMapper.mapDtoToDbModel(it) }
        Log.d("CHECK_RESULT_DTO", dto.toString())
        dao.insertAllResults(dbModel)
    }

    override suspend fun getAllResults(): Flow<List<Results>> {
        val dbModel = dao.getAllResults()
        val rf = MutableStateFlow(dbModel.map { resultsMapper.mapDbModelToEntity(it) })
        return rf.asStateFlow()
    }

    override suspend fun deleteAllResults() {
        dao.deleteAllResults()
    }

}