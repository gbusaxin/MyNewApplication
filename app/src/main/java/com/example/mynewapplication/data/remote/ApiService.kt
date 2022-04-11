package com.example.mynewapplication.data.remote

import com.example.mynewapplication.data.remote.models.FixturesDto
import com.example.mynewapplication.data.remote.models.NewsDto
import com.example.mynewapplication.data.remote.models.ResultsDto
import retrofit2.http.GET

interface ApiService {

    @GET("/mynewapp/uefa_fixtures.json")
    suspend fun getAllFixtures(): List<FixturesDto>

    @GET("/mynewapp/uefa_results.json")
    suspend fun getAllResults(): List<ResultsDto>

    @GET("/mynewapp/uefa_groups.json")
    suspend fun getAllGroups()

    @GET("/mynewapp/uefa_news.json")
    suspend fun getAllNews(): List<NewsDto>
}