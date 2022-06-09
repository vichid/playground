package com.example.navigation.api

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraphBuilder

interface ComposeNavigationFactory {
    fun create(builder: NavGraphBuilder, viewModelStoreOwner: ViewModelStoreOwner)
}
