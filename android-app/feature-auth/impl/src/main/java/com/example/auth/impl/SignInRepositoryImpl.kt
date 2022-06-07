package com.example.auth.impl

import com.example.auth.api.SignInRepository
import com.example.auth.api.UserProfile
import com.example.core.di.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class SignInRepositoryImpl @Inject constructor() : SignInRepository {
    override suspend fun signIn(email: String, password: String): UserProfile {
        return UserProfile("", "", "")
    }
}
