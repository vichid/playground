package com.example.signindata.api

interface SignInRepository {

    suspend fun signIn(email: String, password: String): UserProfile
}

class UserProfile(
    val name: String,
    val profilePicture: String
)
