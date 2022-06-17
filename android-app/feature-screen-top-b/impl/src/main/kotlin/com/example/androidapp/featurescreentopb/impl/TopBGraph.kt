package com.example.androidapp.featurescreentopb.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.androidapp.featurescreentopb.api.TopBDestination

fun NavGraphBuilder.topBGraph(
    navigateToChild: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = TopBDestination.route,
        startDestination = TopBDestination.destination
    ) {
        composable(
            route = TopBDestination.destination,
            content = {
                // val viewModel: TopBViewModel = viewModel()
                TopBScreen(navigateToChild)
            }
        )
        nestedGraphs()
    }
}
