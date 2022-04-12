package com.example.mynewapplication.domain.use_cases.get_all_groups

import com.example.mynewapplication.data.repository.Repository

class GetAllGroupsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllGroups()
}