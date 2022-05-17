package com.example.auth.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.api.SignInDestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.Navigator
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class SignInComposeNavigationFactory @Inject constructor(
    private val navigator: Navigator
) : ComposeNavigationFactory {

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
