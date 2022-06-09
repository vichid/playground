package com.example.navigation.api

import kotlinx.coroutines.flow.Flow

interface Navigator {

    fun navigateUp(): Boolean

    fun navigateBack(): Boolean

    fun navigate(navigationDestination: NavigationDestination): Boolean

    val destinations: Flow<NavigatorEvent>
}
