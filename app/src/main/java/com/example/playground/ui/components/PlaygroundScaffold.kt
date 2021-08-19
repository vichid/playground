package com.example.playground.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.ui.theme.PlaygroundTheme

@Composable
fun PlaygroundScaffold(
    content: @Composable (PaddingValues) -> Unit
) {
    PlaygroundTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                }
            },
            content = content
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlaygroundScaffoldPreview() {
    PlaygroundScaffold { Text(text = "test ") }
}
