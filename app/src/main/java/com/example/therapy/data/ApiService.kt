package com.example.therapy.data

import com.example.therapy.models.therapyModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("therapies")
    suspend fun getTherapies(): Response<therapyModel>
}