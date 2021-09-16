package com.example.logger.wiring

import com.example.base.di.AppScope
import com.example.logger.api.Logger
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface LoggerComponent {
    fun loggerFactory(): Logger
}
