package com.example.playground

import android.app.Application
import com.example.base.di.ComponentHolder

class PlaygroundApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ComponentHolder.components += DaggerAppComponent.create()
    }
}
