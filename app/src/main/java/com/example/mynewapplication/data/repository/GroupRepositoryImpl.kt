package com.example.mynewapplication.data.repository

import android.util.Log
import com.example.mynewapplication.data.local.AppDatabase
import com.example.mynewapplication.data.mappers.GroupMapper
import com.example.mynewapplication.data.remote.ApiService
import com.example.mynewapplication.domain.models.Group
import com.example.mynewapplication.domain.repository.GroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor (
    private val appDatabase: AppDatabase,
    private val groupMapper: GroupMapper,
    private val apiService: ApiService
) : GroupRepository {

    private val dao = appDatabase.getGroupDao()

    override suspend fun loadAllGroups() {
        val dto = apiService.getAllGroups()
        val dbModel = dto.map { groupMapper.mapDtoToDbModel(it) }
        Log.d("CHECK_GROUP_DTO", dto.toString())
        dao.insertAllGroups(dbModel)
    }

    override suspend fun getAllGroups(): Flow<List<Group>> {
        val dbModel = dao.getAllGroups()
        val groupFlow =
            MutableStateFlow<List<Group>>(dbModel.map { groupMapper.mapDbModelToEntity(it) })
        return groupFlow.asStateFlow()
    }


}