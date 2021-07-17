package com.example.catafact

import com.google.gson.annotations.SerializedName

data class SecondaryResult(

    @field:SerializedName("fact")
    val fact: String? = null,

    @field:SerializedName("length")
    val length: Int? = null
)
