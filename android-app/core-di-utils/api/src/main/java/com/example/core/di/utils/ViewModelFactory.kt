package com.example.core.di.utils

import androidx.lifecycle.ViewModel

interface ViewModelFactory {
    fun <T : ViewModel?> create(modelClass: Class<T>): T?
}
