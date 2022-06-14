package com.example.list.screen.api

import com.example.navigation.api.BottomBarDestination
import com.example.navigation.api.NavigationDestination

object ListDestination : NavigationDestination, BottomBarDestination {
    override val route: String = "list"
}
