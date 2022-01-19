package com.example.uicompose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppDimens internal constructor(
    val margin: Dp
) {

    companion object {
        @Composable
        fun defaultDimens(): AppDimens = AppDimens(
            margin = 16.dp
        )
    }
}
