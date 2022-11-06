package com.example.api.interactors

import com.example.api.interfaces.Repository
import com.example.api.models.ProductDetails
import com.example.api.type.Failure
import com.example.entities.AsyncUseCase
import com.example.entities.Either
import com.example.entities.None
import retrofit2.Call

class GetProductDetailsFromRemote(private val repository: Repository)
    : AsyncUseCase<Call<ProductDetails>, None, Failure>() {
    override suspend fun run(params: None)
    : Either<Failure, Call<ProductDetails>> = repository.getProductDetails()
}