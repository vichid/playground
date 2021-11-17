package com.example.signinscreen.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.base.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.Navigator
import com.example.signinscreen.api.SignInDestination
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class SignInComposeNavigationFactory @Inject constructor(
    private val navigator: Navigator
) : ComposeNavigationFactory {

    @ExperimentalAnimationApi
    override fun create(builder: NavGraphBuilder) {
        val viewModel = SignInViewModel(navigator)
        builder.composable(
            route = SignInDestination.route()
        ) { _ ->
            LoginScreen(
                state = viewModel.state,
                onUsernameChanged = { viewModel.onUsernameChanged(it) },
                onPasswordChanged = { viewModel.onPasswordChanged(it) },
                onSubmitClick = { viewModel.onSubmitClick() },
                onBackClick = { viewModel.onBackClick() }
            )
        }
    }
}
