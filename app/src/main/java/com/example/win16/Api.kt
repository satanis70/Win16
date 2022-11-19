package com.example.win16

import com.example.win16.model.AviatorModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("aviator.json")
    fun getData():Call<AviatorModel>
}