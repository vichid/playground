package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.featurescreentopa.api.TopADestination
import com.example.androidapp.featurescreentopb.api.TopBDestination
import com.example.core.di.ComponentHolder
import com.example.navigation.api.NavigationDestination
import com.example.navigation.api.NavigatorEvent
import com.example.uicompose.theme.AppTheme
import kotlinx.coroutines.CoroutineScope

class NavActivity : ComponentActivity() {

    private val appComponent: AppComponent by lazy { ComponentHolder.component() }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            val startRoute = appComponent.launchRouteFactory().route
            val navigationFactorySet = appComponent.topComposeNavigationFactorySet()
            val navigator = appComponent.navigatorFactory()

            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                val navigatorEvent =
                    navigator.destinations.collectAsState(initial = NavigatorEvent.None).value
                LaunchedEffect(navigatorEvent, navigateTo(navigatorEvent, navController))

                Scaffold(
                    modifier = Modifier,
                    bottomBar = {
                        NavigationBar {
                            listOf(TopADestination, TopBDestination).forEach { destination ->
                                val selected =
                                    currentDestination?.hierarchy?.any { it.route == destination.route } == true
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = {
                                        handleTopLevelNavigation(
                                            navDestination = destination,
                                            navController = navController
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = startRoute,
                        modifier = Modifier
                            .padding(padding),
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
    }

    private fun handleTopLevelNavigation(
        navDestination: NavigationDestination,
        navController: NavHostController
    ) {
        navController.navigate(navDestination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    private fun navigateTo(
        navigatorEvent: NavigatorEvent,
        navController: NavHostController
    ): suspend CoroutineScope.() -> Unit = {
        when (navigatorEvent) {
            is NavigatorEvent.Directions -> navController.navigate(navigatorEvent.route) {
                launchSingleTop = true
            }
            NavigatorEvent.NavigateUp -> navController.navigateUp()
            NavigatorEvent.NavigateBack -> navController.popBackStack()
            NavigatorEvent.None -> {}
        }
    }
}
