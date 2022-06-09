package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.di.ComponentHolder
import com.example.navigation.api.NavigatorEvent
import com.example.uicompose.theme.AppTheme

class NavActivity : ComponentActivity() {

    private val appComponent: AppComponent by lazy { ComponentHolder.component() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val startDestination = appComponent.launchRouteFactory().provide()
            val navigationFactorySet = appComponent.composeNavigationFactorySet()
            val destinations = appComponent.navigatorFactory().destinations

            AppTheme {
                val navController = rememberNavController()
                val navigatorEvent =
                    destinations.collectAsState(initial = NavigatorEvent.None).value
                LaunchedEffect(navigatorEvent) {
                    when (navigatorEvent) {
                        is NavigatorEvent.Directions ->
                            navController.navigate(navigatorEvent.destination.route())
                        NavigatorEvent.NavigateUp -> navController.navigateUp()
                        NavigatorEvent.None -> {}
                    }
                }
                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                    builder = {
                        navigationFactorySet
                            .forEach { factory ->
                                factory.create(this, this@NavActivity)
                            }
                    }
                )
            }
        }
    }
}
