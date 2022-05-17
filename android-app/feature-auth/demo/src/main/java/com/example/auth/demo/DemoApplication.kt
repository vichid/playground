package com.example.auth.demo

import android.app.Application
import com.example.core.di.ComponentHolder

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ComponentHolder.components += DaggerSignInAppComponent.create()
    }
}
