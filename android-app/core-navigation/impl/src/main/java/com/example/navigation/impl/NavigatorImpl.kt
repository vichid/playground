package com.example.navigation.impl

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.example.navigation.api.Navigator
import com.example.navigation.api.NavigatorEvent
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class NavigatorImpl @Inject constructor() : Navigator {

    private val navigationEvents: MutableStateFlow<NavigatorEvent> =
        MutableStateFlow(NavigatorEvent.None)

    override val destinations: Flow<NavigatorEvent> = navigationEvents

    override fun navigateUp(): Boolean =
        navigationEvents.tryEmit(NavigatorEvent.NavigateUp)

    override fun navigateBack(): Boolean = navigationEvents.tryEmit(NavigatorEvent.NavigateBack)

    override fun navigate(destination: String): Boolean =
        navigationEvents.tryEmit(NavigatorEvent.Directions(destination))
}
