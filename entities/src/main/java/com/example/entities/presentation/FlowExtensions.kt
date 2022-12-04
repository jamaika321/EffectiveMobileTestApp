package com.example.entities

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.launchWhenStarted(lifecycleCoroutineScope: LifecycleCoroutineScope, function: (T) -> Unit): Flow<T> {
    lifecycleCoroutineScope.launchWhenStarted {
        this@launchWhenStarted.collect() {
            function(it)
        }
    }

    return this
}