package com.example.mynewapplication.data.mappers

import com.example.mynewapplication.data.local.models.FixturesDbModel
import com.example.mynewapplication.data.remote.models.FixturesDto
import com.example.mynewapplication.domain.models.Fixtures
import javax.inject.Inject

class FixturesMapper @Inject constructor() {

    fun mapDtoToDbModel(dto: FixturesDto) = FixturesDbModel(
        id = 0,
        team1 = dto.team1 ?: "",
        image1 = dto.image1 ?: "",
        team2 = dto.team2 ?: "",
        image2 = dto.image2 ?: "",
        time = dto.time ?: "",
        date = dto.date ?: ""
    )

    fun mapDbModelToEntity(dbModel: FixturesDbModel) = Fixtures(
        team1 = dbModel.team1,
        image1 = dbModel.image1,
        team2 = dbModel.team2,
        image2 = dbModel.image2,
        time = dbModel.time,
        date = dbModel.date
    )

}