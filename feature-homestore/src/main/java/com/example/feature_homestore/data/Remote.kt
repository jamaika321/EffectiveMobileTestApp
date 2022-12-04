package com.example.feature_homestore.data

import com.example.api.models.HomePage
import com.example.api.models.ProductDetails
import com.example.api.type.Failure
import com.example.entities.Either
import retrofit2.Response

interface Remote {
    fun getHomePage(): Either<Failure, Response<HomePage>>
    fun getProductDetails(): Either<Failure, Response<ProductDetails>>
}