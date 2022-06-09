package com.example.list.screen.impl

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.di.AppScope
import com.example.list.screen.api.ListDestination
import com.example.navigation.api.ComposeNavigationFactory
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class ListComposeNavigationFactory @Inject constructor() : ComposeNavigationFactory {

    override fun create(builder: NavGraphBuilder, viewModelStoreOwner: ViewModelStoreOwner) {
        builder.composable(
            route = ListDestination.route(),
            content = { ListScreen() }
        )
    }
}
