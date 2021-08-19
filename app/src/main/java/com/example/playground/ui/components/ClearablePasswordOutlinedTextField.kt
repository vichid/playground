package com.example.playground.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@ExperimentalAnimationApi
@Composable
internal fun ClearablePasswordOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
) {
    ClearableOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        hint = hint,
        modifier = modifier,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}
