package com.example.feature_homestore.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.entities.presentation.ViewModelFactory
import com.example.entities.presentation.daggerKeys.ViewModelKey
import com.example.feature_homestore.presentation.HomeStoreFragment
import com.example.feature_homestore.presentation.HomeStoreViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeStoreViewModel::class)
    abstract fun bindMusicViewModel(model: HomeStoreViewModel): ViewModel
}