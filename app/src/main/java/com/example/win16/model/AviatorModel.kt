package com.example.win16.model


import com.google.gson.annotations.SerializedName

data class AviatorModel(
    @SerializedName("aviator")
    val aviator: List<Aviator>
)