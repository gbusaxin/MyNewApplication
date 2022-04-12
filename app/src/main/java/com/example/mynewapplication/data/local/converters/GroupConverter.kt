package com.example.mynewapplication.data.local.converters

import androidx.room.TypeConverter
import com.example.mynewapplication.domain.models.Team
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class GroupConverter {
    @TypeConverter
    fun toListGroup(team:String?):List<Team>{
        if(team == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<Team>>(){}.type
        return Gson().fromJson(team,type)
    }
    @TypeConverter
    fun fromListGroup(team:List<Team>):String{
        return Gson().toJson(team)
    }
}