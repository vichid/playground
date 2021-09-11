package com.example.loginscreen.impl

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.example.playground.ui.theme.PlaygroundTheme
import com.example.uicompose.components.ClearableOutlinedTextField
import com.example.uicompose.components.ClearablePasswordOutlinedTextField
import kotlinx.coroutines.flow.Flow

@ExperimentalAnimationApi
@Composable
internal fun LoginScreen() {
    val viewModel = hiltViewModel<LoginViewModel>()
    val viewState by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = LoginUIState.Empty)
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        ClearableOutlinedTextField(
            value = viewState.username,
            onValueChange = { viewModel.onUsernameChanged(it) },
            hint = "Enter username",
            modifier = Modifier.padding(8.dp)
        )
        ClearablePasswordOutlinedTextField(
            value = viewState.password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            hint = "Enter password"
        )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { viewModel.onSubmitClick() }
        ) {
            Text(
                text = "Submit",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun LoginPreview() {
    PlaygroundTheme {
        LoginScreen()
    }
}

@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): Flow<T> = remember(flow, lifecycle) {
    flow.flowWithLifecycle(
        lifecycle = lifecycle,
        minActiveState = minActiveState
    )
}
