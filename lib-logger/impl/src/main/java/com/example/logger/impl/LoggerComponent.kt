package com.example.logger.impl

import com.example.core.di.AppScope
import com.example.logger.api.Logger
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface LoggerComponent {
    fun loggerFactory(): Logger
}
