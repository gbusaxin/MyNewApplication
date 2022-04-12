package com.example.mynewapplication.data.remote.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class NewsDto(
    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("sDesc")
    @Expose
    val sDesc: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null
)