package com.example.androidapp.featurescreentopa.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.androidapp.featurescreentopa.api.TopADestination

fun NavGraphBuilder.topAGraph(
    navigateToFirstChild: () -> Unit,
    navigateToSecondChild: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = TopADestination.route,
        startDestination = TopADestination.destination
    ) {
        composable(
            route = TopADestination.destination,
            content = {
                // val viewModel: TopAViewModel = viewModel()
                TopAScreen(
                    onFirstChildButtonClick = navigateToFirstChild,
                    onSecondChildButtonClick = navigateToSecondChild
                )
            }
        )
        nestedGraphs()
    }
}
