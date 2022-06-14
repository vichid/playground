package com.example.androidapp.featurescreentopb.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.androidapp.featurescreenchildb.api.ChildBDestination
import com.example.androidapp.featurescreentopb.api.TopBDestination
import com.example.core.di.AppScope
import com.example.navigation.api.ComposeNavigationFactory
import com.example.navigation.api.Navigator
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject
import javax.inject.Named

@ContributesMultibinding(AppScope::class)
@Named("top-navigation")
class TopBComposeNavigationFactory @Inject constructor(
    @Named("route-b") private val navigationFactorySet: Set<@JvmSuppressWildcards ComposeNavigationFactory>,
    private val navigator: Navigator
) : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        with(builder) {
            navigation(
                route = TopBDestination.route,
                startDestination = TopBDestination.destination
            ) {
                composable(
                    route = TopBDestination.destination,
                    content = { TopBScreen { navigator.navigate(ChildBDestination.destination) } }
                )
                navigationFactorySet.forEach { factory ->
                    factory.create(this@with)
                }
            }
        }
    }
}
