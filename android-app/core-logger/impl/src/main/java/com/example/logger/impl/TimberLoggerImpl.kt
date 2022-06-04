package com.example.logger.impl

import com.example.core.di.AppScope
import com.example.logger.api.Logger
import com.example.playground.android_app.core_logger.impl.BuildConfig
import com.squareup.anvil.annotations.ContributesBinding
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ContributesBinding(AppScope::class)
class TimberLoggerImpl @Inject constructor() : Logger {

    override fun setUserId(id: String) {
        TODO("Not yet implemented")
    }

    override fun v(throwable: Throwable?, message: String?, vararg args: Any?) {
        Timber.v(throwable, message, *args)
    }

    override fun d(throwable: Throwable?, message: String?, vararg args: Any?) {
        Timber.d(throwable, message, *args)
    }

    override fun i(throwable: Throwable?, message: String?, vararg args: Any?) {
        Timber.i(throwable, message, *args)
    }

    override fun w(throwable: Throwable?, message: String?, vararg args: Any?) {
        Timber.w(throwable, message, *args)
    }

    override fun e(throwable: Throwable?, message: String?, vararg args: Any?) {
        Timber.e(throwable, message, *args)
    }

    override fun wtf(throwable: Throwable?, message: String?, vararg args: Any?) {
        Timber.wtf(throwable, message, *args)
    }

    companion object {
        fun setup() {
            if (BuildConfig.DEBUG) {
                Timber.plant(Timber.DebugTree())
            } else {
                // crash reporting tree
            }
        }
    }
}
