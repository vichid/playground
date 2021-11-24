package com.example.navigation.impl

import app.cash.turbine.test
import com.example.navigation.api.Navigator
import com.example.navigation.api.NavigatorEvent
import com.google.common.truth.Truth.assertThat
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

        private val path: String = "/login"

        @Test
        fun `should propagate destination`(): Unit = runBlockingTest {
            navigator.destinations.test {
                navigator.navigate { path }
                assertThat((awaitItem() as NavigatorEvent.Directions).destination.route())
                    .isEqualTo(path)
                cancelAndConsumeRemainingEvents()
            }
        }
    }

    @Nested
    inner class OnNavigateUp {

        @Test
        fun `should propagate NavigatorEvent Up`(): Unit = runBlockingTest {
            navigator.destinations.test {
                navigator.navigateUp()

                assertThat(awaitItem()).isInstanceOf(NavigatorEvent.NavigateUp::class.java)
                cancelAndConsumeRemainingEvents()
            }
        }
    }
}
