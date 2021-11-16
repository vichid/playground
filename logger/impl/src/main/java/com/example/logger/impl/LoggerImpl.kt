package com.example.logger.impl

import com.example.base.di.AppScope
import com.example.logger.api.Logger
import com.squareup.anvil.annotations.ContributesBinding

@ContributesBinding(AppScope::class)
object LoggerImpl : Logger
