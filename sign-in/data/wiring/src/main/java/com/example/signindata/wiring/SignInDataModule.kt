package com.example.signindata.wiring

import com.example.signindata.api.SignInRepository
import com.example.signindata.impl.SignInRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SignInDataModule {

    @Singleton
    @Binds
    abstract fun bindSignInRepository(signInRepository: SignInRepositoryImpl): SignInRepository
}
