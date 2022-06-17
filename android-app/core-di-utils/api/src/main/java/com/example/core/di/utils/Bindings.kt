package com.example.core.di.utils

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import androidx.lifecycle.AndroidViewModel
import com.example.core.di.DaggerComponent
import com.example.core.di.DaggerComponentOwner

inline fun <reified T : DaggerComponent> Context.bindings() = bindings(T::class.java)

inline fun <reified T : DaggerComponent> AndroidViewModel.bindings(): T =
    (((this as? DaggerComponentOwner)?.daggerComponents ?: emptyList()).firstOrNull() as? T)
        ?: getApplication<Application>().bindings(T::class.java)

@PublishedApi
internal fun <T : DaggerComponent> Context.bindings(klass: Class<T>): T =
    generateSequence(this) { (it as? ContextWrapper)?.baseContext }
        .plus(applicationContext)
        .filterIsInstance<DaggerComponentOwner>()
        .map { it.daggerComponents }
        .flatMap { it }
        .filterIsInstance(klass)
        .firstOrNull()
        ?: error("Unable to find bindings for ${klass.name}")
