package com.example.uicompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

private val LocalColors = compositionLocalOf<AppColors> {
    error("No colors provided! Make sure to wrap all usages of App components in a AppTheme.")
}
private val LocalTypography = compositionLocalOf<AppTypography> {
    error("No typography provided! Make sure to wrap all usages of App components in a AppTheme.")
}
private val LocalShapes = compositionLocalOf<AppShapes> {
    error("No shapes provided! Make sure to wrap all usages of App components in a AppTheme.")
}
private val LocalDimens = compositionLocalOf<AppDimens> {
    error("No dimens provided! Make sure to wrap all usages of App components in a AppTheme.")
}

@Suppress("LongParameterList")
@Composable
fun AppTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    colors: AppColors = if (isDarkMode) {
        AppColors.defaultDarkColors()
    } else {
        AppColors.defaultLightColors()
    },
    typography: AppTypography = AppTypography.defaultTypography(),
    shapes: AppShapes = AppShapes.defaultShapes(),
    dimens: AppDimens = AppDimens.defaultDimens(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
        LocalDimens provides dimens
    ) {
        content()
    }
}

object AppTheme {

    val colors: AppColors
        @Composable
        get() = LocalColors.current
    val typography: AppTypography
        @Composable
        get() = LocalTypography.current
    val shapes: AppShapes
        @Composable
        get() = LocalShapes.current
    val dimens: AppDimens
        @Composable
        get() = LocalDimens.current
}
