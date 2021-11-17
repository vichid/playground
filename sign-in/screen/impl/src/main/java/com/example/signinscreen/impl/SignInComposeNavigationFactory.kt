package com.example.signinscreen.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
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
    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        val viewModel = SignInViewModel(navigator)
        builder.viewModelComposable(
            route = SignInDestination.route(),
            viewModel = viewModel,
            content = {
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

inline fun <reified VM> NavGraphBuilder.viewModelComposable(
    route: String,
    viewModel: VM,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    crossinline content: @Composable (VM.(NavBackStackEntry) -> Unit),
) where VM : ViewModel {
    composable(route, arguments, deepLinks) { navBackStackEntry ->
        content(viewModel, navBackStackEntry)
    }
}
