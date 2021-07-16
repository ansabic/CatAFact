package com.example.catafact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatFactViewModel(private val repository: Repository) : ViewModel() {
    val randomFact = MutableLiveData<String?>()

    fun getRandomFact() = viewModelScope.launch {
        val result = repository.getRandomFact()
        randomFact.postValue(result)
    }
}