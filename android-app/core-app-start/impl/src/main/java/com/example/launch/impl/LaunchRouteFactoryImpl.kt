package com.example.launch.impl

import com.example.auth.api.SignInDestination
import com.example.core.di.AppScope
import com.example.launch.api.LaunchRouteFactory
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class LaunchRouteFactoryImpl @Inject constructor() : LaunchRouteFactory {
    override fun provide(): String = SignInDestination.route()
}
