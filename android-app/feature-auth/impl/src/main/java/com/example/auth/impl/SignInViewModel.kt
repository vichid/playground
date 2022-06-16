package com.example.auth.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.api.Password
import com.example.auth.api.Username
import com.example.core.di.AppScope
import com.example.core.di.ContributesViewModel
import com.example.core.di.SingleIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesViewModel(AppScope::class)
class SignInViewModel
@Inject constructor() : ViewModel() {

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
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
        initialValue = SignInUIState.Empty,
    )

    fun onUsernameChanged(username: String) {
        _username.value = Username(username)
    }

    fun onPasswordChanged(password: String) {
        _password.value = Password(password)
    }

    fun onSubmitClick() = Unit

    companion object {
        const val TIMEOUT_MILLIS = 5000L
    }
}
