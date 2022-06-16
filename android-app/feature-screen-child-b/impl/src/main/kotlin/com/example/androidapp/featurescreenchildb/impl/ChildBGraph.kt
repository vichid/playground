package com.example.androidapp.featurescreenchildb.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreenchildb.api.ChildBDestination

fun NavGraphBuilder.childBGraph() {
    composable(
        route = ChildBDestination.destination,
        content = { ChildBScreen() }
    )
}
