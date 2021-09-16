package com.example.navigation.impl

import androidx.navigation.NavOptionsBuilder
import com.example.base.di.AppScope
import com.example.navigation.api.Navigator
import com.example.navigation.api.NavigatorEvent
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow

@ContributesBinding(AppScope::class)
class NavigatorImpl @Inject constructor() : Navigator {

    private val _navigationEvents = MutableSharedFlow<NavigatorEvent>()
    override val destinations = _navigationEvents

    override fun navigateUp(): Boolean =
        _navigationEvents.tryEmit(NavigatorEvent.NavigateUp)

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        _navigationEvents.tryEmit(NavigatorEvent.Directions(route, builder))
}
