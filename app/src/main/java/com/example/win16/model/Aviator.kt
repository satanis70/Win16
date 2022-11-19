package com.example.win16.model


import com.google.gson.annotations.SerializedName

data class Aviator(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)