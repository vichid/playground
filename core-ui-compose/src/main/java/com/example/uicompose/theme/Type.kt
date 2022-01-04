package com.example.uicompose.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.uicompose.R

val montserratFamily = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

private val defaultTypography = Typography()
val appTypography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = montserratFamily),
    h2 = defaultTypography.h2.copy(fontFamily = montserratFamily),
    h3 = defaultTypography.h3.copy(fontFamily = montserratFamily),
    h4 = defaultTypography.h4.copy(fontFamily = montserratFamily),
    h5 = defaultTypography.h5.copy(fontFamily = montserratFamily),
    h6 = defaultTypography.h6.copy(fontFamily = montserratFamily),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = montserratFamily),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = montserratFamily),
    body1 = defaultTypography.body1.copy(fontFamily = montserratFamily),
    body2 = defaultTypography.body2.copy(fontFamily = montserratFamily),
    button = defaultTypography.button.copy(fontFamily = montserratFamily),
    caption = defaultTypography.caption.copy(fontFamily = montserratFamily),
    overline = defaultTypography.overline.copy(fontFamily = montserratFamily)
)

internal val LocalTypography = staticCompositionLocalOf { appTypography }
