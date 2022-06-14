package com.example.androidapp.featurescreentopb.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreentopb.api.TopBDestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class TopBComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = TopBDestination.route,
            content = { TopBScreen() }
        )
    }
}
