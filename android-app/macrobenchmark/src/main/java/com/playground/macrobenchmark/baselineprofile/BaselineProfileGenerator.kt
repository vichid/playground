package com.playground.macrobenchmark.baselineprofile

import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import org.junit.Rule
import org.junit.Test

/**
 * Generates a baseline profile which can be copied to `app/src/main/baseline-prof.txt`.
 */
@ExperimentalBaselineProfilesApi
class BaselineProfileGenerator {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun startup() =
        baselineProfileRule.collectBaselineProfile(
            packageName = "com.example.playground"
        ) {
            pressHome()
            startActivityAndWait()
        }
}
