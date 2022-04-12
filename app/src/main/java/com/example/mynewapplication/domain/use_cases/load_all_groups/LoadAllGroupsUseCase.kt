package com.example.mynewapplication.domain.use_cases.load_all_groups

import com.example.mynewapplication.data.repository.Repository

class LoadAllGroupsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadAllGroups()
}