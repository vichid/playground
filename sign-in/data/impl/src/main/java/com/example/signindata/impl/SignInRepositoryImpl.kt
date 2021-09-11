package com.example.signindata.impl

import com.example.signindata.api.SignInRepository
import com.example.signindata.api.UserProfile

class SignInRepositoryImpl : SignInRepository {
    override suspend fun signIn(email: String, password: String): UserProfile {
        TODO("Not yet implemented")
    }
}
