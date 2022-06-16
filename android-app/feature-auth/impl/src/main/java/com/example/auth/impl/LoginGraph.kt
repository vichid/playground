package com.example.auth.impl

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.api.SignInDestination

fun NavGraphBuilder.loginGraph() {
    composable(
        route = SignInDestination.route
    ) {
        val viewModel: SignInViewModel = viewModel()

        LoginScreen(
            state = viewModel.state,
            onUsernameChanged = viewModel::onUsernameChanged,
            onPasswordChanged = viewModel::onPasswordChanged,
            onSubmitClick = viewModel::onSubmitClick
        )
    }
}
