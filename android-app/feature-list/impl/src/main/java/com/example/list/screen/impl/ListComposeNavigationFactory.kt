package com.example.list.screen.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.di.AppScope
import com.example.list.screen.api.ListDestination
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject
import javax.inject.Named

@ContributesMultibinding(AppScope::class)
@Named("top-navigation")
class ListComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = ListDestination.route,
            content = { ListScreen() }
        )
    }
}
