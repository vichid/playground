package com.example.signinscreen.demo

import android.app.Application
import com.example.base.di.ComponentHolder

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ComponentHolder.components += DaggerSignInAppComponent.create()
    }
}
