package com.example.core.di.utils

import androidx.lifecycle.ViewModel

inline fun <reified VM : ViewModel> getViewModel(viewModelSet: Set<@JvmSuppressWildcards ViewModelFactory>): VM =
    viewModelSet.firstNotNullOf { it.create(VM::class.java) }
