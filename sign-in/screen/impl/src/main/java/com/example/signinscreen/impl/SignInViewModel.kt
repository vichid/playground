package com.example.signinscreen.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation.api.Navigator
import com.example.signindata.api.Password
import com.example.signindata.api.Username
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    private val _username = MutableStateFlow(Username(""))
    private val _password = MutableStateFlow(Password(""))

    val state: StateFlow<SignInUIState> = combine(
        _username,
        _password
    ) { username, password ->
        SignInUIState(
            username = username.value,
            password = password.value
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SignInUIState.Empty,
    )

    fun onUsernameChanged(username: String) {
        _username.value = Username(username)
    }

    fun onPasswordChanged(password: String) {
        _password.value = Password(password)
    }

    fun onSubmitClick() {
        navigator.navigate("list")
    }
}
