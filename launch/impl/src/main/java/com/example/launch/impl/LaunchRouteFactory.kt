package com.example.launch.impl

import javax.inject.Inject

class LaunchRouteFactoryImpl @Inject constructor() : LaunchRouteFactory {
    override fun provide(): String = "login"
}

interface LaunchRouteFactory {
    fun provide(): String
}
