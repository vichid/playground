package com.example.navigation.api

import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    object NavigateUp : NavigatorEvent()
    class Directions(
        val destination: NavigationDestination,
        val builder: NavOptionsBuilder.() -> Unit
    ) : NavigatorEvent()
}
