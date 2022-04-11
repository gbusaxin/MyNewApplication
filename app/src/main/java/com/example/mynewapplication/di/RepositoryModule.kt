package com.example.mynewapplication.di

import android.content.Context
import com.example.mynewapplication.data.local.AppDatabase
import com.example.mynewapplication.data.mappers.FixturesMapper
import com.example.mynewapplication.data.mappers.NewsMapper
import com.example.mynewapplication.data.mappers.ResultsMapper
import com.example.mynewapplication.data.remote.ApiService
import com.example.mynewapplication.data.repository.*
import com.example.mynewapplication.domain.repository.FixturesRepository
import com.example.mynewapplication.domain.repository.NewsRepository
import com.example.mynewapplication.domain.repository.OnBoardingOperations
import com.example.mynewapplication.domain.repository.ResultsRepository
import com.example.mynewapplication.domain.use_cases.UseCases
import com.example.mynewapplication.domain.use_cases.delete_all_fixtures.DeleteAllFixturesUseCase
import com.example.mynewapplication.domain.use_cases.delete_all_results.DeleteAllResultsUseCase
import com.example.mynewapplication.domain.use_cases.get_all_fixtures.GetAllFixturesUseCase
import com.example.mynewapplication.domain.use_cases.get_all_results.GetAllResultsUseCase
import com.example.mynewapplication.domain.use_cases.get_news.GetNewsUseCase
import com.example.mynewapplication.domain.use_cases.get_on_boarding_state.GetOnBoardingStateUseCase
import com.example.mynewapplication.domain.use_cases.get_selected_news.GetSelectedNewsUseCase
import com.example.mynewapplication.domain.use_cases.load_all_fixtures.LoadAllFixturesUseCase
import com.example.mynewapplication.domain.use_cases.load_all_results.LoadAllResultsUseCase
import com.example.mynewapplication.domain.use_cases.load_news.LoadNewsUseCase
import com.example.mynewapplication.domain.use_cases.set_on_boarding_state.SetOnBoardingStateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideOnBoardingOperations(
        @ApplicationContext context: Context
    ): OnBoardingOperations {
        return OnBoardingOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        database: AppDatabase,
        apiService: ApiService,
        newsMapper: NewsMapper
    ): NewsRepository {
        return NewsRepositoryImpl(
            database = database,
            apiService = apiService,
            newsMapper = newsMapper
        )
    }

    @Provides
    @Singleton
    fun provideFixturesRepository(
        database: AppDatabase,
        apiService: ApiService,
        fixturesMapper: FixturesMapper
    ): FixturesRepository {
        return FixturesRepositoryImpl(
            database, apiService, fixturesMapper
        )
    }

    @Provides
    @Singleton
    fun provideResultsRepository(
        database: AppDatabase,
        apiService: ApiService,
        mapper: ResultsMapper
    ): ResultsRepository {
        return ResultsRepositoryImpl(
            database = database,
            apiService = apiService,
            resultsMapper = mapper
        )
    }

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            setOnBoardingState = SetOnBoardingStateUseCase(repository = repository),
            getOnBoardingState = GetOnBoardingStateUseCase(repository = repository),
            getNewsUseCase = GetNewsUseCase(repository = repository),
            loadNewsUseCase = LoadNewsUseCase(repository = repository),
            getSelectedNewsUseCase = GetSelectedNewsUseCase(repository = repository),
            getAllFixturesUseCase = GetAllFixturesUseCase(repository = repository),
            loadAllFixturesUseCase = LoadAllFixturesUseCase(repository = repository),
            deleteAllFixturesUseCase = DeleteAllFixturesUseCase(repository = repository),
            loadAllResultsUseCase = LoadAllResultsUseCase(repository = repository),
            getAllResultsUseCase = GetAllResultsUseCase(repository = repository),
            deleteAllResultsUseCase = DeleteAllResultsUseCase(repository = repository)
        )
    }
}