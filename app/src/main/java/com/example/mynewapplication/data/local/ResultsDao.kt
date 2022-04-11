package com.example.mynewapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynewapplication.data.local.models.ResultsDbModel

@Dao
interface ResultsDao {
    @Query("SELECT * FROM results_table")
    fun getAllResults(): List<ResultsDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllResults(results: List<ResultsDbModel>)

    @Query("DELETE FROM results_table")
    suspend fun deleteAllResults()
}