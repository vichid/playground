package com.example.navigation.wiring

import com.example.navigation.api.Navigator
import com.example.navigation.impl.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {

    @Binds
    abstract fun navigator(navigator: NavigatorImpl): Navigator
}
