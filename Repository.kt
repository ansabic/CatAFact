package com.example.catafact

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository() {
    private val mainClient = ApiService.mainClient
    private val secondaryClient = ApiServiceSecondary.secondaryClient

    suspend fun getRandomFact(): String? = withContext(Dispatchers.IO) {
        val result = mainClient.getFact()
        return@withContext if (result.isSuccessful)
            result.body()?.text
        else
            null
    }

    suspend fun getRandomFactSecondary(): String? = withContext(Dispatchers.IO) {
        val result = secondaryClient.getSecondaryFact()
        return@withContext if (result.isSuccessful)
            result.body()?.fact
        else
            null
    }
}