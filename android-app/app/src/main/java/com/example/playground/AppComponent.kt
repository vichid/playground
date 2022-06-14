package com.example.playground

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.example.launch.api.LaunchRouteFactory
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.Navigator
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Named

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {
    fun launchRouteFactory(): LaunchRouteFactory
    fun navigatorFactory(): Navigator

    @Named("top-navigation")
    fun topComposeNavigationFactorySet(): Set<ComposeNavigationFactory>
}
