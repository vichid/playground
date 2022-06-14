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
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.auth.api.SignInDestination
import com.example.core.di.ComponentHolder
import com.example.list.screen.api.ListDestination
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
            val navigator = appComponent.navigatorFactory()

            AppTheme {
                val navController = rememberNavController()
                val navigatorEvent =
                    navigator.destinations.collectAsState(initial = NavigatorEvent.None).value
                LaunchedEffect(navigatorEvent, navigateTo(navigatorEvent, navController))

                Scaffold(
                    modifier = Modifier,
                    bottomBar = {
                        NavigationBar {
                            listOf(SignInDestination, ListDestination).forEach {
                                NavigationBarItem(
                                    selected = false,
                                    onClick = { navigator.navigate(it) },
                                    icon = {
                                        Icon(
                                            Icons.Outlined.Check,
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
                        startDestination = startDestination,
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

    private fun navigateTo(
        navigatorEvent: NavigatorEvent,
        navController: NavHostController
    ): suspend CoroutineScope.() -> Unit = {
        when (navigatorEvent) {
            is NavigatorEvent.Directions ->
                navController.navigate(navigatorEvent.destination.route) {
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
