package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.base.di.ComponentHolder
import com.example.launch.wiring.LaunchComponent
import com.example.navigation.wiring.NavigationComponent
import com.example.playground.ui.theme.PlaygroundTheme

class NavActivity : ComponentActivity() {

    private val launchComponent: LaunchComponent by lazy { ComponentHolder.component() }
    private val navigationComponent: NavigationComponent by lazy { ComponentHolder.component() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaygroundTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = launchComponent.launchRouteFactory().provide(),
                    builder = {
                        navigationComponent.composeNavigationFactorySet().forEach { factory ->
                            factory.create(this, navController)
                        }
                    }
                )
            }
        }
    }
}
