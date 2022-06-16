package com.example.playground

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.example.launch.api.LaunchRouteFactory
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {
    fun launchRouteFactory(): LaunchRouteFactory
}
