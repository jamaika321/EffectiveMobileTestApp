package com.example.feature_homestore.remote

import com.example.api.models.HomePage
import com.example.api.models.ProductDetails
import com.example.api.type.Failure
import com.example.core_network.ApiService
import com.example.core_network.RetrofitBuilder
import com.example.entities.Either
import com.example.feature_homestore.data.Remote
import retrofit2.Response

class RemoteImpl: Remote {
    override fun getHomePage(): Either<Failure, Response<HomePage>> {
        return Either.Right(RetrofitBuilder.makeService<ApiService>(true).getHomePage())
    }

    override fun getProductDetails(): Either<Failure, Response<ProductDetails>> {
        return Either.Right(RetrofitBuilder.makeService<ApiService>(true).getProductDetails())
    }
}