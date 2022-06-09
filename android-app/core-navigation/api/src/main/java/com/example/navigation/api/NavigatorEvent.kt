package com.example.navigation.api

sealed interface NavigatorEvent {
    object NavigateUp : NavigatorEvent
    object NavigateBack : NavigatorEvent
    object None : NavigatorEvent
    class Directions(val destination: NavigationDestination) : NavigatorEvent
}
