package com.example.feature_homestore.di.modules

import android.app.Application
import android.content.Context
import com.example.api.interactors.GetHomePageFromRemote
import com.example.api.interfaces.Repository
import com.example.entities.presentation.base.BaseApplication
import com.example.feature_homestore.data.Remote
import com.example.feature_homestore.data.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule(private val context: Context) {

    @Provides
    fun provideAppContext(): Context = context

    @Provides
    fun provideApplication(): Application = context as BaseApplication

    @Provides
    fun provideGetHomePageFromRemote(repository: Repository): GetHomePageFromRemote {
        return GetHomePageFromRemote(repository)
    }

}