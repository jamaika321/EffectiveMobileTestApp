package com.example.core_network

import com.example.api.models.HomePage
import com.example.api.models.ProductDetails
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun getHomePage(): Response<HomePage>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getProductDetails(): Response<ProductDetails>
}