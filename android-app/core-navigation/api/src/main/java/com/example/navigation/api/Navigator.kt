package com.example.navigation.api

import kotlinx.coroutines.flow.Flow

interface Navigator {

    fun navigateUp(): Boolean

    fun navigateBack(): Boolean

    fun navigate(destination: String): Boolean

    val destinations: Flow<NavigatorEvent>
}
