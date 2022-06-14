package com.example.androidapp.featurescreentopa.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.androidapp.featurescreenchilda.api.FirstChildADestination
import com.example.androidapp.featurescreenchilda.api.SecondChildADestination
import com.example.androidapp.featurescreentopa.api.TopADestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.Navigator
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject
import javax.inject.Named

@ContributesMultibinding(AppScope::class)
@Named("top-navigation")
class TopAComposeNavigationFactory @Inject constructor(
    @Named("route-a") private val navigationFactorySet: Set<@JvmSuppressWildcards ComposeNavigationFactory>,
    private val navigator: Navigator
) : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        with(builder) {
            navigation(
                route = TopADestination.route,
                startDestination = TopADestination.destination
            ) {
                composable(
                    route = TopADestination.destination,
                    content = {
                        TopAScreen(
                            { navigator.navigate(FirstChildADestination.destination) },
                            { navigator.navigate(SecondChildADestination.destination) }
                        )
                    }
                )
                navigationFactorySet.forEach { factory ->
                    factory.create(this@with)
                }
            }
        }
    }
}
