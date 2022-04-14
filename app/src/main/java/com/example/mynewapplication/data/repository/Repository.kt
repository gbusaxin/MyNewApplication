package com.example.mynewapplication.data.repository

import com.example.mynewapplication.data.remote.models.ResponseDto
import com.example.mynewapplication.domain.models.Fixtures
import com.example.mynewapplication.domain.models.Group
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.domain.models.Results
import com.example.mynewapplication.domain.repository.OnBoardingOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val onBoardingOperations: OnBoardingOperations,
    private val newsRepository: NewsRepositoryImpl,
    private val fixturesRepository: FixturesRepositoryImpl,
    private val resultsRepository: ResultsRepositoryImpl,
    private val groupRepository: GroupRepositoryImpl,
    private val chromeRepository: ChromeRepositoryImpl
) {

    suspend fun setOnBoardingState(completed: Boolean) {
        onBoardingOperations.setOnBoardingState(completed = completed)
    }

    fun getOnBoardingState(): Flow<Boolean> {
        return onBoardingOperations.getOnBoardingState()
    }

    suspend fun getAllNews(): Flow<List<News>> {
        return newsRepository.getAllNews()
    }

    suspend fun loadAllNews() {
        newsRepository.loadAllNews()
    }

    suspend fun getSelectedNews(id: Int): News {
        return newsRepository.getSelectedNews(id = id)
    }

    suspend fun deleteAllNews() {
        newsRepository.deleteAllNews()
    }

    suspend fun getAllFixtures(): Flow<List<Fixtures>> {
        return fixturesRepository.getAllFixtures()
    }

    suspend fun loadAllFixtures() {
        fixturesRepository.loadAllFixtures()
    }

    suspend fun deleteAllFixtures() {
        fixturesRepository.deleteAllFixtures()
    }

    suspend fun getAllResults(): Flow<List<Results>> {
        return resultsRepository.getAllResults()
    }

    suspend fun loadAllResults() {
        resultsRepository.loadAllResults()
    }

    suspend fun deleteAllResults() {
        resultsRepository.deleteAllResults()
    }

    suspend fun loadAllGroups() {
        groupRepository.loadAllGroups()
    }

    suspend fun getAllGroups(): Flow<List<Group>> {
        return groupRepository.getAllGroups()
    }

    suspend fun sendLocale(): ResponseDto {
        return chromeRepository.sendLocale()
    }

    fun getLocale(): String {
        return chromeRepository.getLocale()
    }

}