package com.example.mynewapplication.data.mappers

import com.example.mynewapplication.data.local.models.ResultsDbModel
import com.example.mynewapplication.data.remote.models.ResultsDto
import com.example.mynewapplication.domain.models.Results
import javax.inject.Inject

class ResultsMapper @Inject constructor() {

    fun mapDtoToDbModel(dto: ResultsDto) = ResultsDbModel(
        id = 0,
        team1 = dto.team1 ?: "",
        image1 = dto.image1 ?: "",
        team2 = dto.team2 ?: "",
        image2 = dto.image2 ?: "",
        date = dto.date ?: "",
        result = dto.result ?: "",
        group = dto.group ?: ""
    )

    fun mapDbModelToEntity(dbModel: ResultsDbModel) = Results(
        team1 = dbModel.team1,
        image1 = dbModel.image1,
        team2 = dbModel.team2,
        image2 = dbModel.image2,
        date = dbModel.date,
        result = dbModel.result,
        group = dbModel.group
    )
}