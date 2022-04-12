package com.example.mynewapplication.domain.repository

import com.example.mynewapplication.data.remote.models.ResponseDto

interface ChromeRepository {

    suspend fun sendLocale(): ResponseDto
    fun getLocale(): String

}