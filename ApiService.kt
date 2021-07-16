package com.example.catafact

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("facts/random?animal_type=cat&amount=1")
    suspend fun getFact():Response<Result>

    companion object {
        val client: ApiService = Retrofit
            .Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("https://cat-fact.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}