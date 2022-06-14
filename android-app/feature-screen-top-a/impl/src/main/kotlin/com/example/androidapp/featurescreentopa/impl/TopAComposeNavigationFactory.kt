package com.example.androidapp.featurescreentopa.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreentopa.api.TopADestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class TopAComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = TopADestination.route,
            content = { TopAScreen() }
        )
    }
}
