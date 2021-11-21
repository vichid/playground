package com.example.navigation.impl

import com.example.navigation.api.Navigator
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class NavigatorImplTest {

    lateinit var navigator: Navigator

    @BeforeEach
    fun setUp() {
        navigator = NavigatorImpl()
    }

    @Nested
    inner class OnNavigate {

        private val path = "/login"

        @BeforeEach
        fun runTest() {
            navigator.navigate { path }
        }

        @Test
        fun `should propagate destination`(): Unit = runBlockingTest {
            navigator.destinations
                .onEach {
                    assertThat(it).isEqualTo(path)
                }
        }
    }
}
