package com.example.navigation.impl

import com.example.base.di.AppScope
import com.example.navigation.api.NavigationDestination
import com.example.navigation.api.Navigator
import com.example.navigation.api.NavigatorEvent
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

@Singleton
@ContributesBinding(AppScope::class)
class NavigatorImpl @Inject constructor() : Navigator {

    private val navigationEvents: MutableSharedFlow<NavigatorEvent> =
        MutableSharedFlow(extraBufferCapacity = 1)
    override val destinations: SharedFlow<NavigatorEvent> = navigationEvents.asSharedFlow()

    override fun navigateUp(): Boolean =
        navigationEvents.tryEmit(NavigatorEvent.NavigateUp)

    override fun navigate(navigationDestination: NavigationDestination): Boolean =
        navigationEvents.tryEmit(NavigatorEvent.Directions(navigationDestination))
}