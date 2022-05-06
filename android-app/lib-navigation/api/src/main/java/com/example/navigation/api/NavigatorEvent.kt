package com.example.navigation.api

sealed class NavigatorEvent {
    object NavigateUp : NavigatorEvent()
    class Directions(val destination: NavigationDestination) : NavigatorEvent()
}
