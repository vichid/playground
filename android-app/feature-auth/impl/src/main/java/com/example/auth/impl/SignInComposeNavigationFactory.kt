package com.example.auth.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.api.SignInDestination
import com.example.core.di.AppScope
import com.example.core.di.utils.ViewModelFactory
import com.example.core.di.utils.getViewModel
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class SignInComposeNavigationFactory @Inject constructor(
    private val viewModelSet: Set<@JvmSuppressWildcards ViewModelFactory>
) : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = SignInDestination.route
        ) {
            val viewModel: SignInViewModel = getViewModel(viewModelSet)

            LoginScreen(
                state = viewModel.state,
                onUsernameChanged = viewModel::onUsernameChanged,
                onPasswordChanged = viewModel::onPasswordChanged,
                onSubmitClick = viewModel::onSubmitClick
            )
        }
    }
}
