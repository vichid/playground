package com.example.navigation.api

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.SharedFlow

interface Navigator {

    fun navigateUp(): Boolean

    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
    ): Boolean

    val destinations: SharedFlow<NavigatorEvent>
}
