package com.example.logger.impl

import timber.log.Timber

object TimberSetup {
    fun setup() {
        Timber.plant(Timber.DebugTree())
    }
}
