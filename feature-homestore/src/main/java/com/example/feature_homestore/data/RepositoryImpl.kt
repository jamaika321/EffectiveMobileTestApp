package com.example.feature_homestore.data

import com.example.api.interfaces.Repository
import com.example.api.models.HomePage
import com.example.api.models.ProductDetails
import com.example.api.type.Failure
import com.example.entities.Either
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remote: Remote
): Repository {
    override suspend fun getHomePageFromRemote(): Either<Failure, Response<HomePage>> = remote.getHomePage()

    override fun getProductDetailsFromRemote(): Either<Failure, Response<ProductDetails>> = remote.getProductDetails()
}