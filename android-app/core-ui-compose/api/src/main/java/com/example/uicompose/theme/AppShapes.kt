package com.example.uicompose.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class AppShapes internal constructor(
    val listItem: Shape
) {

    companion object {
        @Composable
        fun defaultShapes(): AppShapes = AppShapes(
            listItem = RoundedCornerShape(16.dp)
        )
    }
}
