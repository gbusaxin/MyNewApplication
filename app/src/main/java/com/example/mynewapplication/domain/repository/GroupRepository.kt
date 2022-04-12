package com.example.mynewapplication.domain.repository

import com.example.mynewapplication.domain.models.Group
import kotlinx.coroutines.flow.Flow

interface GroupRepository {

    suspend fun loadAllGroups()

    suspend fun getAllGroups(): Flow<List<Group>>

}