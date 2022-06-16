package com.example.androidapp.featurescreenchilda.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidapp.featurescreenchilda.api.SecondChildADestination

fun NavGraphBuilder.secondChildAGraph() {
    composable(
        route = SecondChildADestination.destination,
        content = { SecondChildAScreen() }
    )
}
