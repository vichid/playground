package com.example.playground

import android.app.Application
import com.example.core.di.DaggerComponent
import com.example.core.di.DaggerComponentOwner

class PlaygroundApplication : Application(), DaggerComponentOwner {
    override lateinit var daggerComponents: List<DaggerComponent>

    override fun onCreate() {
        super.onCreate()
        daggerComponents = listOf(DaggerAppComponent.create())
    }
}
