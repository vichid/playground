package com.example.navigation.api

import kotlinx.coroutines.flow.SharedFlow

interface Navigator {

    fun navigateUp(): Boolean

    fun navigate(navigationDestination: NavigationDestination): Boolean

    val destinations: SharedFlow<NavigatorEvent>
}
