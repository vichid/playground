package com.example.launch.wiring

import com.example.launch.impl.LaunchRouteFactory
import com.example.launch.impl.LaunchRouteFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object LaunchModule {

    @Module
    @InstallIn(SingletonComponent::class)
    internal abstract class Bindings {

        @Binds
        abstract fun bindLaunchRouteFactory(
            factory: LaunchRouteFactoryImpl
        ): LaunchRouteFactory
    }
}
