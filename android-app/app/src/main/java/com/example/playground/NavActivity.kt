package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.di.ComponentHolder
import com.example.navigation.api.NavigatorEvent
import com.example.uicompose.theme.AppTheme
import kotlinx.coroutines.CoroutineScope

class NavActivity : ComponentActivity() {

    private val appComponent: AppComponent by lazy { ComponentHolder.component() }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            val startDestination = appComponent.launchRouteFactory().provide()
            val navigationFactorySet = appComponent.composeNavigationFactorySet()
            val destinations = appComponent.navigatorFactory().destinations

            AppTheme {
                val navController = rememberNavController()
                val navigatorEvent =
                    destinations.collectAsState(initial = NavigatorEvent.None).value
                LaunchedEffect(navigatorEvent, navigateTo(navigatorEvent, navController))
                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                    builder = {
                        navigationFactorySet
                            .forEach { factory ->
                                factory.create(this)
                            }
                    }
                )
            }
        }
    }

    private fun navigateTo(
        navigatorEvent: NavigatorEvent,
        navController: NavHostController
    ): suspend CoroutineScope.() -> Unit = {
        when (navigatorEvent) {
            is NavigatorEvent.Directions ->
                navController.navigate(navigatorEvent.destination.route()) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                    restoreState = true
                }
            NavigatorEvent.NavigateUp -> navController.navigateUp()
            NavigatorEvent.NavigateBack -> navController.popBackStack()
            NavigatorEvent.None -> {}
        }
    }
}
