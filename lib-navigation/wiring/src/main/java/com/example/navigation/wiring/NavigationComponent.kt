package com.example.navigation.wiring

import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.Navigator
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface NavigationComponent {
    fun navigatorFactory(): Navigator
    fun composeNavigationFactorySet(): Set<ComposeNavigationFactory>
}
