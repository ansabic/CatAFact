package com.example.catafact

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceSecondary {

    @GET("fact?max_length=140")
    suspend fun getSecondaryFact(): Response<SecondaryResult>

    companion object {
        val secondaryClient = Retrofit
            .Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl(secondaryUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiceSecondary::class.java)
    }
}