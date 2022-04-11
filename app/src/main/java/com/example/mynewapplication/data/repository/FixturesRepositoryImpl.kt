package com.example.mynewapplication.data.repository

import android.util.Log
import com.example.mynewapplication.data.local.AppDatabase
import com.example.mynewapplication.data.mappers.FixturesMapper
import com.example.mynewapplication.data.remote.ApiService
import com.example.mynewapplication.domain.models.Fixtures
import com.example.mynewapplication.domain.repository.FixturesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FixturesRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: ApiService,
    private val fixturesMapper: FixturesMapper
) : FixturesRepository {

    private val dao = database.getFixturesDao()

    override suspend fun loadAllFixtures() {
        val dto = apiService.getAllFixtures()
        val dbModel = dto.map { fixturesMapper.mapDtoToDbModel(it) }
        Log.d("CHECK_FIXTURES_LOAD", dto.toString())
        dao.insertAllFixtures(dbModel)
    }

    override suspend fun getAllFixtures(): Flow<List<Fixtures>> {
        val dbModel = dao.getAllFixtures()
        val fixturesFlow = MutableStateFlow(dbModel.map { fixturesMapper.mapDbModelToEntity(it) })
        Log.d("CHECK_FIXTURES_FLOW", fixturesFlow.value.toString())
        return fixturesFlow.asStateFlow()
    }

    override suspend fun deleteAllFixtures() {
        dao.deleteAllFixtures()
    }


}