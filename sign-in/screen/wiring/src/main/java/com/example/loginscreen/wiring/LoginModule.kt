package com.example.loginscreen.wiring

import com.example.loginscreen.impl.LoginComposeNavigationFactory
import com.example.navigation.api.ComposeNavigationFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LoginModule {

    @Singleton
    @Binds
    @IntoSet
    abstract fun bindComposeNavigationFactory(
        factory: LoginComposeNavigationFactory
    ): ComposeNavigationFactory
}
