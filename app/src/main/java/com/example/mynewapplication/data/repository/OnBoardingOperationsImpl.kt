package com.example.mynewapplication.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.mynewapplication.domain.repository.OnBoardingOperations
import com.example.mynewapplication.utils.Constants.PREFERENCES_KEY
import com.example.mynewapplication.utils.Constants.PREFERENCES_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class OnBoardingOperationsImpl(context: Context) : OnBoardingOperations {
    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun setOnBoardingState(completed: Boolean) {
        dataStore.edit {
            it[PreferencesKey.onBoardingKey] = completed
        }
    }

    override fun getOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch {
                if (it is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                val onBoardingState = it[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}