package com.example.auth.api

import com.example.navigation.api.BottomBarDestination
import com.example.navigation.api.NavigationDestination

object SignInDestination : NavigationDestination, BottomBarDestination {
    override val route: String = "login"
}
