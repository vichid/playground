package com.example.auth.impl

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.api.SignInDestination

fun NavGraphBuilder.loginGraph() {
    composable(
        route = SignInDestination.route
    ) {
        val viewModel: SignInViewModel = viewModel()
        val signInUIState = viewModel.state.collectAsState().value
        LoginScreen(
            signInUIState = signInUIState,
            onUsernameChanged = viewModel::onUsernameChanged,
            onPasswordChanged = viewModel::onPasswordChanged,
            onSubmitClick = viewModel::onSubmitClick
        )
    }
}
