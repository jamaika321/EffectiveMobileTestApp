package com.example.feature_homestore.di.components

import com.example.entities.presentation.BaseDaggerComponent
import com.example.feature_homestore.di.modules.DataModule
import com.example.feature_homestore.di.modules.DomainModule
import com.example.feature_homestore.di.modules.ViewModelModule
import com.example.feature_homestore.presentation.HomeStoreFragment
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [DomainModule::class, ViewModelModule::class, DataModule::class])
interface HomeStoreComponent: BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(domainModule: DomainModule): HomeStoreComponent
    }
    fun inject(homeStoreFragment: HomeStoreFragment)
}