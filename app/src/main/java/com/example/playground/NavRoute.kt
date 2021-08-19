package com.example.playground

sealed class NavRoute(val route: String) {

    object Login : NavRoute("login")
    object List : NavRoute("list")
}
