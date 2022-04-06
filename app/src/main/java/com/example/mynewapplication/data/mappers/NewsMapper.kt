package com.example.mynewapplication.data.mappers

import com.example.mynewapplication.data.local.models.NewsDbModel
import com.example.mynewapplication.data.remote.models.NewsDto
import com.example.mynewapplication.domain.models.News
import javax.inject.Inject

class NewsMapper @Inject constructor(){

    fun mapDtoToDbModel(dto: NewsDto):NewsDbModel{
        return NewsDbModel(
            image = dto.image?:"",
            title = dto.title?:"",
            sDesc = dto.sDesc?:"",
            date = dto.date?:"",
            description = dto.description?:""
        )
    }

    fun mapDbModelToEntity(dbModel: NewsDbModel):News{
        return News(
            image = dbModel.image,
            title = dbModel.title,
            sDesc = dbModel.sDesc,
            date = dbModel.date,
            description = dbModel.description
        )
    }
}