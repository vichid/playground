package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.di.ComponentHolder
import com.example.launch.impl.LaunchComponent
import com.example.navigation.api.NavigatorEvent
import com.example.navigation.impl.NavigationComponent
import com.example.playground.ui.theme.PlaygroundTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NavActivity : ComponentActivity() {

    private val launchComponent: LaunchComponent by lazy { ComponentHolder.component() }
    private val navigationComponent: NavigationComponent by lazy { ComponentHolder.component() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaygroundTheme {
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    navigationComponent.navigatorFactory()
                        .destinations
                        .onEach { navigatorEvent ->
                            when (navigatorEvent) {
                                is NavigatorEvent.Directions ->
                                    navController.navigate(navigatorEvent.destination.route())
                                NavigatorEvent.NavigateUp -> navController.navigateUp()
                            }
                        }
                        .launchIn(lifecycleScope)
                }

                NavHost(
                    navController = navController,
                    startDestination = launchComponent.launchRouteFactory().provide(),
                    builder = {
                        navigationComponent.composeNavigationFactorySet().forEach { factory ->
                            factory.create(this)
                        }
                    }
                )
            }
        }
    }
}
