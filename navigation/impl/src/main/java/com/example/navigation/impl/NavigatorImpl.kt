package com.example.navigation.impl

import androidx.navigation.NavOptionsBuilder
import com.example.base.di.AppScope
import com.example.navigation.api.Navigator
import com.example.navigation.api.NavigatorEvent
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

@ContributesBinding(AppScope::class)
object NavigatorImpl : Navigator {

    private val navigationEvents: MutableSharedFlow<NavigatorEvent> =
        MutableSharedFlow(extraBufferCapacity = 1)
    override val destinations: SharedFlow<NavigatorEvent> = navigationEvents.asSharedFlow()

    override fun navigateUp(): Boolean =
        navigationEvents.tryEmit(NavigatorEvent.NavigateUp)

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigationEvents.tryEmit(NavigatorEvent.Directions(route, builder))
}
