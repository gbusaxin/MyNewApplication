package com.example.mynewapplication.data.repository

import com.example.mynewapplication.domain.models.Fixtures
import com.example.mynewapplication.domain.models.News
import com.example.mynewapplication.domain.models.Results
import com.example.mynewapplication.domain.repository.OnBoardingOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val onBoardingOperations: OnBoardingOperations,
    private val newsRepository: NewsRepositoryImpl,
    private val fixturesRepository: FixturesRepositoryImpl,
    private val resultsRepository: ResultsRepositoryImpl
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

    suspend fun getSelectedNews(title: String): News {
        return newsRepository.getSelectedNews(title = title)
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

}