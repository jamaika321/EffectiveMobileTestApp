package com.example.api.interfaces

import com.example.api.models.HomePage
import com.example.api.models.ProductDetails
import com.example.api.type.Failure
import com.example.entities.Either
import retrofit2.Call
import retrofit2.Response

interface Repository {
    fun getHomePageFromRemote(): Either<Failure, Response<HomePage>>
    fun getProductDetailsFromRemote(): Either<Failure, Response<ProductDetails>>
}