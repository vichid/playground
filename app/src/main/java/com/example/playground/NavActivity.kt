package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playground.ui.PlaygroundScaffold
import com.example.playground.ui.login.LoginScreen
import com.example.playground.ui.login.LoginUIState
import com.example.playground.ui.login.LoginViewModel
import com.example.playground.ui.rememberFlowWithLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startDestination = NavRoute.Login.route
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                composable(NavRoute.Login.route) {
                    val viewModel: LoginViewModel = hiltViewModel()
                    val viewState by rememberFlowWithLifecycle(viewModel.state)
                        .collectAsState(initial = LoginUIState.Empty)
                    LoginScreen(
                        state = viewState,
                        onUsernameChanged = { viewModel.onUsernameChanged(it) },
                        onPasswordChanged = { viewModel.onPasswordChanged(it) },
                        onLoginSubmit = { viewModel.onSubmitClick() }
                    )
                }
                composable(NavRoute.List.route) {
                    PlaygroundScaffold {}
                }
            }
        }
    }
}
