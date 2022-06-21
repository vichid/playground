package com.example.auth.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uicompose.components.ClearableOutlinedTextField
import com.example.uicompose.components.ClearablePasswordOutlinedTextField
import com.example.uicompose.theme.AppTheme

@Composable
internal fun LoginScreen(
    signInUIState: SignInUIState,
    onUsernameChanged: (username: String) -> Unit,
    onPasswordChanged: (password: String) -> Unit,
    onSubmitClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClearableOutlinedTextField(
            value = signInUIState.username,
            onValueChange = { onUsernameChanged(it) },
            hint = "Enter username",
            modifier = Modifier.padding(8.dp)
        )
        ClearablePasswordOutlinedTextField(
            value = signInUIState.password,
            onValueChange = { onPasswordChanged(it) },
            hint = "Enter password"
        )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { onSubmitClick() }
        ) {
            Text(
                text = "Submit",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    AppTheme {
        LoginScreen(SignInUIState.Empty, { }, { }, { })
    }
}
