package com.example.mynewapplication.data.mappers

import com.example.mynewapplication.data.local.models.GroupDbModel
import com.example.mynewapplication.data.remote.models.GroupDto
import com.example.mynewapplication.domain.models.Group
import java.util.*
import javax.inject.Inject

class GroupMapper @Inject constructor() {

    fun mapDbModelToEntity(dbModel:GroupDbModel) = Group(
        group = dbModel.group,
        teams = dbModel.teams
    )

    fun mapDtoToDbModel(dto:GroupDto) = GroupDbModel(
        group = dto.group?:"",
        teams = dto.teams?:Collections.emptyList()
    )
}