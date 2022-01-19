package com.example.uicompose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors internal constructor(
    val textColor: Color,
    val itemBackground: Color
) {

    companion object {
        @Composable
        fun defaultLightColors(): AppColors = AppColors(
            textColor = Color.Green,
            itemBackground = Color.Gray
        )

        @Composable
        fun defaultDarkColors(): AppColors = AppColors(
            textColor = Color.Yellow,
            itemBackground = Color.Black
        )
    }
}
