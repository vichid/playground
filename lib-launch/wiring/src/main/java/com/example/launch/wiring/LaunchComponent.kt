package com.example.launch.wiring

import com.example.core.di.AppScope
import com.example.launch.api.LaunchRouteFactory
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface LaunchComponent {
    fun launchRouteFactory(): LaunchRouteFactory
}
