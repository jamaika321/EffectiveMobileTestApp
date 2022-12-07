package com.example.entities.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver

open class BaseViewModel(application: Application): AndroidViewModel(application), LifecycleObserver {
    open fun init() = Unit
}