package com.example.signinscreen.impl

import androidx.compose.runtime.Immutable

@Immutable
internal data class SignInUIState(val username: String = "", val password: String = "") {
    companion object {
        val Empty = SignInUIState()
    }
}
