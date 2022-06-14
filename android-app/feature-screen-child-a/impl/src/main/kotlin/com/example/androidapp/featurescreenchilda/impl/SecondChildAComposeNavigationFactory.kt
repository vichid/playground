package com.example.androidapp.featurescreenchilda.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreenchilda.api.SecondChildADestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject
import javax.inject.Named

@ContributesMultibinding(AppScope::class)
@Named("route-a")
class SecondChildAComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = SecondChildADestination.destination,
            content = { SecondChildAScreen() }
        )
    }
}
