package com.example.workapp

import retrofit2.Call
import retrofit2.http.GET

interface QueryForApi {
    @GET("/vmc_json")
    fun getCurrentData(): Call<List<ServerResponse>>
}