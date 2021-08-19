@file:OptIn(ExperimentalAnimationApi::class)

package com.example.playground.ui.login

import androidx.compose.animation.ExperimentalAnimationApi
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
import com.example.playground.ui.components.ClearableOutlinedTextField
import com.example.playground.ui.components.ClearablePasswordOutlinedTextField
import com.example.playground.ui.theme.PlaygroundTheme

@Composable
internal fun LoginScreen(
    state: LoginUIState,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginSubmit: () -> Unit
) {
    PlaygroundTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            ClearableOutlinedTextField(
                value = state.username,
                onValueChange = { onUsernameChanged(it) },
                hint = "Enter username",
                modifier = Modifier.padding(8.dp)
            )
            ClearablePasswordOutlinedTextField(
                value = state.password,
                onValueChange = { onPasswordChanged(it) },
                hint = "Enter password"
            )
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { onLoginSubmit() }
            ) {
                Text(
                    text = "Submit",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen(
        LoginUIState.Empty,
        {},
        {},
        {}
    )
}