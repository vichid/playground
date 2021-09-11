package com.example.authstatus.api

import kotlinx.coroutines.flow.Flow

interface ObserveAuthStatusUseCase {
    fun execute(): Flow<AuthStatus>
}

sealed class AuthStatus
object Authenticated : AuthStatus()
object Anonymous : AuthStatus()