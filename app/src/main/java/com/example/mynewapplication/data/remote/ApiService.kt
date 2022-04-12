package com.example.mynewapplication.data.remote

import com.example.mynewapplication.data.remote.models.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/mynewapp/uefa_fixtures.json")
    suspend fun getAllFixtures(): List<FixturesDto>

    @GET("/mynewapp/uefa_results.json")
    suspend fun getAllResults(): List<ResultsDto>

    @GET("/mynewapp/uefa_groups.json")
    suspend fun getAllGroups(): List<GroupDto>

    @GET("/mynewapp/uefa_news.json")
    suspend fun getAllNews(): List<NewsDto>

    @POST("/mynewapp/webview/splash.php")
    suspend fun sendLocale(@Body locale: RequestDto): ResponseDto

}