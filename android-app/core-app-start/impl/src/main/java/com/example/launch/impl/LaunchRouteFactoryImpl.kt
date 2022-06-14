package com.example.launch.impl

import com.example.androidapp.featurescreentopa.api.TopADestination
import com.example.core.di.AppScope
import com.example.launch.api.LaunchRouteFactory
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class LaunchRouteFactoryImpl @Inject constructor() : LaunchRouteFactory {
    override val route: String = TopADestination.route
}
