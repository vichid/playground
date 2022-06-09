package com.example.core.di.utils

import androidx.lifecycle.ViewModel
import com.example.core.di.DaggerSet

inline fun <reified VM : ViewModel> appViewModel(set: DaggerSet<ViewModelFactory>): VM =
    set.firstNotNullOf { it.create(VM::class.java) }
