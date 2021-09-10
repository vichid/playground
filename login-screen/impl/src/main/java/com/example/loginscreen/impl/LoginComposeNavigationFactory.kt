package com.example.loginscreen.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.api.ComposeNavigationFactory
import javax.inject.Inject

class LoginComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    @ExperimentalAnimationApi
    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.composable(
            route = "login",
            content = {
                LoginScreen()
            }
        )
    }
}
