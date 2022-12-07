package com.example.effectivemobiletestapp.presentation

import android.app.Application
import android.content.Context
import com.example.effectivemobiletestapp.di.component.AppComponent
import com.example.effectivemobiletestapp.di.component.DaggerAppComponent
import com.example.entities.presentation.BaseDaggerComponent
import com.example.entities.presentation.base.BaseApplication
import com.example.feature_homestore.di.components.HomeStoreComponent
import com.example.feature_homestore.di.modules.DomainModule
import java.lang.IllegalArgumentException


class App : BaseApplication() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

    override fun provideComponent(type: Class<out BaseDaggerComponent>): BaseDaggerComponent {
        return when(type){
            HomeStoreComponent::class.java -> appComponent.createHomeStoreComponent().create(
                DomainModule(this)
            )

            else -> throw IllegalArgumentException("rere $type")
        }
    }
}