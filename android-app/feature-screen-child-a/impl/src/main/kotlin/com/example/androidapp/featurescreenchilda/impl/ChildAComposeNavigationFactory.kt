package com.example.androidapp.featurescreenchilda.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreenchilda.api.ChildADestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class ChildAComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = ChildADestination.route,
            content = { ChildAScreen() }
        )
    }
}
