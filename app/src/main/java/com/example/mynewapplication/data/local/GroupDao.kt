package com.example.mynewapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynewapplication.data.local.models.GroupDbModel

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllGroups(groups: List<GroupDbModel>)

    @Query("SELECT * FROM group_table")
    fun getAllGroups(): List<GroupDbModel>


}