package com.example.mynewapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynewapplication.data.local.models.FixturesDbModel

@Dao
interface FixturesDao {

    @Query("SELECT * FROM fixtures_table")
    fun getAllFixtures(): List<FixturesDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFixtures(fixtures: List<FixturesDbModel>)

    @Query("DELETE FROM fixtures_table")
    suspend fun deleteAllFixtures()

}