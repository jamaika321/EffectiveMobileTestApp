package com.example.api.interfaces

import com.example.api.models.HomePage
import com.example.api.models.ProductDetails
import com.example.api.type.Failure
import com.example.entities.Either
import retrofit2.Call

interface Repository {
    fun getHomePageFromRemote(): Either<Failure, Call<HomePage>>
    fun getProductDetails(): Either<Failure, Call<ProductDetails>>
}