package com.example.auth.api

import com.example.navigation.api.NavigationDestination

object SignInDestination : NavigationDestination {
    override fun route(): String = "login"
}
