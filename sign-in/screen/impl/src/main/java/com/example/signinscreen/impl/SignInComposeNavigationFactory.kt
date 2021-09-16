package com.example.signinscreen.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.base.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class SignInComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    @ExperimentalAnimationApi
    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.composable(
            route = "login",
            content = {
                val viewModel = SignInViewModel()
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
