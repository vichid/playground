package com.example.playground

import com.example.core.di.AppScope
import com.example.core.di.DaggerComponent
import com.example.core.di.SingleIn
import com.example.launch.api.LaunchRouteFactory
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent : DaggerComponent {

    fun launchRouteFactory(): LaunchRouteFactory

    fun inject(navActivity: NavActivity)
}
