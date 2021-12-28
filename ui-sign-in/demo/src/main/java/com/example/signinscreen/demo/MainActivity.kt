package com.example.signinscreen.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.di.ComponentHolder
import com.example.navigation.impl.NavigationComponent
import com.example.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {

    private val navigationComponent: NavigationComponent by lazy { ComponentHolder.component() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login",
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
