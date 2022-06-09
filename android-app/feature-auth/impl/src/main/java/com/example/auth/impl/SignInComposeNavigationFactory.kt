package com.example.auth.impl

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.api.SignInDestination
import com.example.core.di.AppScope
import com.example.core.di.DaggerSet
import com.example.core.di.utils.ViewModelFactory
import com.example.core.di.utils.appViewModel
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class SignInComposeNavigationFactory @Inject constructor(
    private val viewModelSet: DaggerSet<ViewModelFactory>
) : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder, viewModelStoreOwner: ViewModelStoreOwner) {
        builder.composable(
            route = SignInDestination.route()
        ) { _ ->

            val viewModel: SignInViewModel = appViewModel(viewModelSet)

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
