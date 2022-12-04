package com.example.entities.presentation.base

import android.app.Application
import com.example.entities.presentation.BaseDaggerComponent

abstract class BaseApplication: Application() {
    val components = mutableMapOf<Class<out BaseDaggerComponent>, BaseDaggerComponent>()

    inline fun <reified T : BaseDaggerComponent> getComponent(): T {
        if (components[T::class.java] == null)
            components[T::class.java] = provideComponent(T::class.java)
        return components[T::class.java] as T
    }

    abstract fun provideComponent(type: Class<out BaseDaggerComponent>): BaseDaggerComponent

}