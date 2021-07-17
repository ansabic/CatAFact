package com.example.catafact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {
    val randomFact = MutableLiveData<String?>()
    private val repository = Repository()

    fun getRandomFact() = viewModelScope.launch {
        val result = repository.getRandomFactSecondary()
        randomFact.postValue(result)
    }
}