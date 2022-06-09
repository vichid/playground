package com.example.playground

import androidx.lifecycle.ViewModel

interface ViewModelFactoryPlugin {
    fun <T : ViewModel?> create(modelClass: Class<T>): T?
}
