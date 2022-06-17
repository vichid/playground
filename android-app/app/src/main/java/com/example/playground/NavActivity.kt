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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.featurescreenchilda.api.FirstChildADestination
import com.example.androidapp.featurescreenchilda.api.SecondChildADestination
import com.example.androidapp.featurescreenchilda.impl.firstChildAGraph
import com.example.androidapp.featurescreenchilda.impl.secondChildAGraph
import com.example.androidapp.featurescreenchildb.api.ChildBDestination
import com.example.androidapp.featurescreenchildb.impl.childBGraph
import com.example.androidapp.featurescreentopa.api.TopADestination
import com.example.androidapp.featurescreentopa.impl.topAGraph
import com.example.androidapp.featurescreentopb.api.TopBDestination
import com.example.androidapp.featurescreentopb.impl.topBGraph
import com.example.core.di.utils.bindings
import com.example.launch.api.LaunchRouteFactory
import com.example.navigation.api.NavigationDestination
import com.example.uicompose.theme.AppTheme
import javax.inject.Inject

class NavActivity : ComponentActivity() {

    @Inject
    lateinit var launchRouteFactory: LaunchRouteFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        bindings<AppComponent>().inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            val startRoute = launchRouteFactory.route

            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

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
                        builder = buildGraph(navController)
                    )
                }
            }
        }
    }

    private fun buildGraph(navController: NavHostController): NavGraphBuilder.() -> Unit =
        {
            topAGraph(
                navigateToFirstChild = {
                    navController.navigate(FirstChildADestination.destination)
                },
                navigateToSecondChild = {
                    navController.navigate(SecondChildADestination.destination)
                },
                nestedGraphs = topANestedGraph()
            )
            topBGraph(
                navigateToChild = {
                    navController.navigate(ChildBDestination.destination)
                },
                nestedGraphs = {
                    childBGraph()
                }
            )
        }

    private fun topANestedGraph(): NavGraphBuilder.() -> Unit = {
        firstChildAGraph()
        secondChildAGraph()
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
}
