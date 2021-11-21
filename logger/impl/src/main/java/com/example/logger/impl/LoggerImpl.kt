package com.example.logger.impl

import com.example.base.di.AppScope
import com.example.logger.api.Logger
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ContributesBinding(AppScope::class)
class LoggerImpl @Inject constructor() : Logger
