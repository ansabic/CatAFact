package com.example.catafact

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val apiService: ApiService) {

    suspend fun getRandomFact(): String? = withContext(Dispatchers.IO) {
        val result = apiService.getFact()
        return@withContext if(result.isSuccessful)
            result.body()?.text
        else
            null
    }
}