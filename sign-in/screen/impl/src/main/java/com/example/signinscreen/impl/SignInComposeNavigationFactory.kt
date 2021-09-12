package com.example.signinscreen.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.api.ComposeNavigationFactory
import javax.inject.Inject

class SignInComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    @ExperimentalAnimationApi
    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.composable(
            route = "login",
            content = {
                val viewModel = hiltViewModel<SignInViewModel>()
                LoginScreen(
                    viewModel.state,
                    { viewModel.onUsernameChanged(it) },
                    { viewModel.onPasswordChanged(it) },
                    { viewModel.onSubmitClick() }
                )
            }
        )
    }
}
