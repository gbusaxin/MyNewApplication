package com.example.mynewapplication.data.remote.models

import androidx.annotation.Keep
import com.example.mynewapplication.domain.models.Team

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class GroupDto(
    @SerializedName("group")
    @Expose
    val group: String? = null,
    @SerializedName("teams")
    @Expose
    val teams: List<Team>? = null
)