package com.example.androidapp.featurescreenchilda.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreenchilda.api.FirstChildADestination

fun NavGraphBuilder.firstChildAGraph() {
    composable(
        route = FirstChildADestination.destination,
        content = { FirstChildAScreen() }
    )
}
