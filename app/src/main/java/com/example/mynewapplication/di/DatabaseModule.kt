package com.example.mynewapplication.di

import android.content.Context
import androidx.room.Room
import com.example.mynewapplication.data.local.AppDatabase
import com.example.mynewapplication.domain.use_cases.UseCases
import com.example.mynewapplication.utils.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    fun provideOnBoardingOperations(
        appDatabase: AppDatabase
    ): UseCases {
        return UseCases()
    }

}