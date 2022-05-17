package com.example.auth.impl

import androidx.compose.runtime.Immutable

@Immutable
data class SignInUIState(val username: String = "", val password: String = "") {
    companion object {
        val Empty = SignInUIState()
    }
}
