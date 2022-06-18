package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.core.di.utils.bindings
import com.example.launch.api.LaunchRouteFactory
import javax.inject.Inject

class NavActivity : ComponentActivity() {

    @Inject
    lateinit var launchRouteFactory: LaunchRouteFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        bindings<AppComponent>().inject(this)
        super.onCreate(savedInstanceState)
        val startRoute = launchRouteFactory.route

        setContent { AppContent(startRoute = startRoute) }
    }
}
