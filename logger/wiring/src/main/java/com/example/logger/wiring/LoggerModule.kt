package com.example.logger.wiring

import com.example.logger.api.Logger
import com.example.logger.impl.LoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LoggerModule {

    @Binds
    abstract fun bindLogger(appLogImpl: LoggerImpl): Logger
}
