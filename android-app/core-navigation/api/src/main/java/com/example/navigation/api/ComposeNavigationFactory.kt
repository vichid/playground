package com.example.navigation.api

import androidx.navigation.NavGraphBuilder

interface ComposeNavigationFactory {
    fun create(builder: NavGraphBuilder)
}
