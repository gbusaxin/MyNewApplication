package com.example.mynewapplication.data.repository

import android.content.res.Resources
import android.util.Log
import androidx.core.os.ConfigurationCompat
import com.example.mynewapplication.data.remote.ApiService
import com.example.mynewapplication.data.remote.models.RequestDto
import com.example.mynewapplication.data.remote.models.ResponseDto
import com.example.mynewapplication.domain.repository.ChromeRepository
import javax.inject.Inject

class ChromeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ChromeRepository {

    override suspend fun sendLocale(): ResponseDto {
        val locale = getLocale()
        val request = RequestDto(request = locale)
        Log.d("CHECK_LOCALE", "SEND")
        return apiService.sendLocale(request)
    }

    override fun getLocale(): String {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
        Log.d("CHECK_LOCALE", lang.isO3Language)
        return lang.isO3Language
    }

}