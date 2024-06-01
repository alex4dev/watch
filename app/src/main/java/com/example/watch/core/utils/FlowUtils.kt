package com.manpower.interimaires.app.utils

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


inline fun <T> Flow<T>.collect(
    owner: LifecycleOwner, crossinline onCollect: suspend (T) -> Unit
): Flow<T> = this.flowWithLifecycle(owner.lifecycle, Lifecycle.State.STARTED).onEach {
    onCollect(it)
}.also { it.launchIn(owner.lifecycleScope) }

