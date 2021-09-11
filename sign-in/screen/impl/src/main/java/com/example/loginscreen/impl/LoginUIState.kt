package com.example.loginscreen.impl

import androidx.compose.runtime.Immutable

@Immutable
internal data class LoginUIState(val username: String = "", val password: String = "") {
    companion object {
        val Empty = LoginUIState()
    }
}
