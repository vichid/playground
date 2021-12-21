package com.example.logger.impl

import android.content.Context
import androidx.startup.Initializer

class LoggerInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        TimberLoggerImpl.setup()
        return
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
