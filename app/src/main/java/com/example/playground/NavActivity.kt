package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.NavigatorEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class NavActivity : ComponentActivity() {

    @Inject
    lateinit var composeNavigationFactories: @JvmSuppressWildcards Set<ComposeNavigationFactory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel = hiltViewModel<NavViewModel>()
            LaunchedEffect(navController) {
                viewModel.destinations.collect {
                    when (val event = it) {
                        is NavigatorEvent.NavigateUp -> navController.navigateUp()
                        is NavigatorEvent.Directions -> navController.navigate(
                            event.destination,
                            event.builder
                        )
                    }
                }
            }
            NavHost(
                navController = navController,
                startDestination = "login",
                builder = {
                    composeNavigationFactories.forEach { factory ->
                        factory.create(this, navController)
                    }
                }
            )
        }
    }
}
