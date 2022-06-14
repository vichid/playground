package com.example.androidapp.featurescreentopa.impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun TopAScreen(
    onFirstChildButtonClick: () -> Unit,
    onSecondChildButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Top A")
        Button(onClick = onFirstChildButtonClick) {
            Text(text = "First Child A")
        }
        Button(onClick = onSecondChildButtonClick) {
            Text(text = "Second Child A")
        }
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    TopAScreen({}, {})
}
