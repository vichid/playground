package com.example.signindata.impl

import com.example.base.di.AppScope
import com.example.signindata.api.SignInRepository
import com.example.signindata.api.UserProfile
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class SignInRepositoryImpl @Inject constructor() : SignInRepository {
    override suspend fun signIn(email: String, password: String): UserProfile {
        TODO("Not yet implemented")
    }
}
