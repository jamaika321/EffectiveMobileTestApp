package com.example.feature_homestore.di.modules

import com.example.api.interactors.GetHomePageFromRemote
import com.example.api.interfaces.Repository
import com.example.feature_homestore.data.Remote
import com.example.feature_homestore.data.RepositoryImpl
import com.example.feature_homestore.remote.RemoteImpl
import dagger.Module
import dagger.Provides


@Module
class DataModule {

    @Provides
    fun provideRepository(remote: Remote): Repository = RepositoryImpl(remote)

    @Provides
    fun provideRemote(): Remote = RemoteImpl()
}