package com.example.api.interactors

import com.example.api.interfaces.Repository
import com.example.api.models.HomePage
import com.example.api.type.Failure
import com.example.entities.AsyncUseCase
import com.example.entities.Either
import com.example.entities.None
import retrofit2.Response

class GetHomePageFromRemote(private val repository: Repository): AsyncUseCase<Response<HomePage>, None, Failure>() {
    override suspend fun run(params: None):
            Either<Failure, Response<HomePage>> = repository.getHomePageFromRemote()
}