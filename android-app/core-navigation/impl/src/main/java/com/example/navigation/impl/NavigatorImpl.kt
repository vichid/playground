package com.example.navigation.impl

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.example.navigation.api.NavigationDestination
import com.example.navigation.api.Navigator
import com.example.navigation.api.NavigatorEvent
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@SingleIn(AppScope::class)
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
