package com.example.uicompose.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider

@JvmInline
value class ThemePreviewValue(val value: Boolean)

class IsDarkThemeParamProvider : CollectionPreviewParameterProvider<ThemePreviewValue>(
    listOf(
        ThemePreviewValue(true),
        ThemePreviewValue(false)
    )
)
