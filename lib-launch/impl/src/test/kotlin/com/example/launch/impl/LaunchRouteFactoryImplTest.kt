package com.example.launch.impl

import com.example.launch.api.LaunchRouteFactory
import com.example.signinscreen.api.SignInDestination
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class LaunchRouteFactoryImplTest {

    lateinit var launchRouteFactory: LaunchRouteFactory

    @BeforeEach
    fun setUp() {
        launchRouteFactory = LaunchRouteFactoryImpl()
    }

    @Nested
    inner class OnProvide {

        @Test
        fun `should provide sign in route`() {
            assertThat(launchRouteFactory.provide())
                .isEqualTo(SignInDestination.route())
        }
    }
}
