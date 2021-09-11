package com.example.loginscreen.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.types.Password
import com.example.base.types.Username
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor() : ViewModel() {

    private val _username = MutableStateFlow(Username(""))
    private val _password = MutableStateFlow(Password(""))

    val state: StateFlow<LoginUIState> = combine(
        _username,
        _password
    ) { username, password ->
        LoginUIState(
            username = username.value,
            password = password.value
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = LoginUIState.Empty,
    )

    fun onUsernameChanged(username: String) {
        _username.value = Username(username)
    }

    fun onPasswordChanged(password: String) {
        _password.value = Password(password)
    }

    fun onSubmitClick() {
        Log.d("", "")
    }
}
