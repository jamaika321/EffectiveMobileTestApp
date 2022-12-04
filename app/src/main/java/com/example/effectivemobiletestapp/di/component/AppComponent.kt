package com.example.effectivemobiletestapp.di.component

import com.example.effectivemobiletestapp.presentation.MainActivity
import com.example.feature_homestore.di.components.HomeStoreComponent
import com.example.feature_homestore.presentation.HomeStoreFragment
import dagger.Component

@Component
interface AppComponent {
    fun createHomeStoreComponent(): HomeStoreComponent.Factory
}