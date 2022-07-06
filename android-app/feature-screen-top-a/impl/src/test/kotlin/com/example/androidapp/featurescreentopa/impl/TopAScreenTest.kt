package com.example.androidapp.featurescreentopa.impl

import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class TopAScreenTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun snapTopAScreen() {
        paparazzi.snapshot {
            TopAScreen({}, {})
        }
    }
}
