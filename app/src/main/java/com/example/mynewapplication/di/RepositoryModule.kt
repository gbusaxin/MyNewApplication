package com.example.mynewapplication.di

import android.content.Context
import com.example.mynewapplication.data.repository.OnBoardingOperationsImpl
import com.example.mynewapplication.data.repository.Repository
import com.example.mynewapplication.domain.repository.OnBoardingOperations
import com.example.mynewapplication.domain.use_cases.UseCases
import com.example.mynewapplication.domain.use_cases.get_on_boarding_state.GetOnBoardingStateUseCase
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
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            setOnBoardingState = SetOnBoardingStateUseCase(repository = repository),
            getOnBoardingState = GetOnBoardingStateUseCase(repository = repository)
        )
    }
}