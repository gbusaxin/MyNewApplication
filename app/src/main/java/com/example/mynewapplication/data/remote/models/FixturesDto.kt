package com.example.mynewapplication.data.remote.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class FixturesDto(
    @SerializedName("team1")
    @Expose
    val team1: String? = null,

    @SerializedName("image1")
    @Expose
    val image1: String? = null,

    @SerializedName("team2")
    @Expose
    val team2: String? = null,

    @SerializedName("image2")
    @Expose
    val image2: String? = null,

    @SerializedName("time")
    @Expose
    val time: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null
)