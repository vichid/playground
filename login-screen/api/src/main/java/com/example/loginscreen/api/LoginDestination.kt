package com.example.loginscreen.api

import androidx.navigation.compose.NamedNavArgument
import com.example.navigation.api.NavigationDestination

object LoginDestination : NavigationDestination {

    override fun route(): String = "login"

    override val arguments: List<NamedNavArgument>
        get() = emptyList()
}
