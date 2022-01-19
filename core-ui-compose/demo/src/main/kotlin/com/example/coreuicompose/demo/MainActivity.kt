package com.example.coreuicompose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.uicompose.preview.IsDarkThemeParamProvider
import com.example.uicompose.preview.ThemePreviewValue
import com.example.uicompose.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Text(
                    text = "Lorem ipsum"
                )
            }
        }
    }
}

@Preview
@Composable
internal fun DefaultPreview(
    @PreviewParameter(IsDarkThemeParamProvider::class) themePreviewValue: ThemePreviewValue
) {
    AppTheme(isDarkMode = themePreviewValue.value) {
        Text(
            text = "Lorem ipsum",
            fontStyle = FontStyle.Italic
        )
    }
}
