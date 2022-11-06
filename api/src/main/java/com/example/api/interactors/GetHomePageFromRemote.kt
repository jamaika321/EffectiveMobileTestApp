package com.example.api.interactors

import com.example.api.interfaces.Repository
import com.example.api.models.HomePage
import com.example.api.type.Failure
import com.example.entities.AsyncUseCase
import com.example.entities.Either
import com.example.entities.None
import retrofit2.Call

class GetHomePageFromRemote(private val repository: Repository): AsyncUseCase<Call<HomePage>, None, Failure>() {
    override suspend fun run(params: None):
            Either<Failure, Call<HomePage>> = repository.getHomePageFromRemote()
}