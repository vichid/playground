package com.example.navigation.api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface ComposeNavigationFactory {
    fun create(builder: NavGraphBuilder, navController: NavHostController)
}
